/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackoverflow.ans;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author user
 */
public class Test {

    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 13002;

        try {
            System.out.println("Connecting to " + serverName + " on port "
                    + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to "
                    + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            System.out.println("Hello from " + client.getLocalSocketAddress());
            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            if (in.read() != -1) {
                System.out.println("Server says " + in.readUTF());
            }

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
