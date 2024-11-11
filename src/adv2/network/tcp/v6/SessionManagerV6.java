package adv2.network.tcp.v6;

import java.util.ArrayList;
import java.util.List;

// 동시성 처리 ( ex. remove - add 동시 호출 방지, remove - closeAll 동시 호출 방지 )
public class SessionManagerV6 {

    private List<SessionV6> sessions = new ArrayList<>();

    public synchronized void add(SessionV6 session) {
        sessions.add(session);
    }

    // 상황: 클라이언트에서 종료하는 경우 ( 세션매니저에서 제거 )
    public synchronized void remove(SessionV6 session) {
        sessions.remove(session);
    }

    // 상황: 서버가 종료되는 경우 ( 각 세션에서 사용중인 자원 정리 및 세션매니저 초기화 )
    public synchronized void closeAll() {
        for (SessionV6 session : sessions) {
            session.close();
        }

        sessions.clear();
    }
}
