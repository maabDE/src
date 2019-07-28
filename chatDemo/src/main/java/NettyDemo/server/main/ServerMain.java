package NettyDemo.server.main;

import NettyDemo.server.NettyServer;

public class ServerMain {
    public static void main(String[] args) throws InterruptedException {
        new NettyServer().run();
    }
}
