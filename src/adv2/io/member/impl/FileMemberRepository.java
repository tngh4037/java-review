package adv2.io.member.impl;

import adv2.io.member.Member;
import adv2.io.member.MemberRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-txt.dat";
    private static final String DELIMITER = ",";

    @Override
    public void add(Member member) {
        try (
                FileWriter fw = new FileWriter(FILE_PATH, StandardCharsets.UTF_8,true);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();

        try (
                FileReader fr = new FileReader(FILE_PATH, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(fr);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] memberData = line.split(",");
                Member member = new Member(memberData[0], memberData[1], Integer.valueOf(memberData[2]));
                members.add(member);
            }
            return members;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
