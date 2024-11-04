package jdv1.nested.nested.ex2;

public class Network {

    public void sendMessage(String text) {
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }

    private static class NetworkMessage {
        private String message;

        public NetworkMessage(String message) {
            this.message = message;
        }

        public void print() {
            System.out.println(message);
        }
    }
}
