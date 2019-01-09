package edu.gvsu.cis371; /**
 * Created by Charles on 5/10/2016.
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class WebClient {

    public static void main(String[] args){
        String host = "www.cis.gvsu.edu";
        int port = 80;
        String file = "/~kurmasz/Humor/stupid.html";

        try {
            Socket socket = new Socket(host, port);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            output.println("GET " + file + " HTTP/1.1");
            output.println("HOST: " + host);
            output.println("");
            output.flush();

            String nextLine = "";
            while ((nextLine = input.readLine()) != null && nextLine.length() != 0)
            {
                System.out.println(nextLine);
            }
            PrintWriter stream = new PrintWriter(new File("Output.txt"));

            while((nextLine = input.readLine()) != null){
                stream.println(nextLine);
            }
            stream.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        /**
         * Outline of a very basic web transaction
         * Created by kurmasz on 4/27/15.
         */
        // (1) Create a socket connecting to the host and port set up above.
        // (2) Get the InputStream from the socket and "wrap it up"
        // (3) Get the OutputStream from the socket and "wrap it up"

        // This web page demonstrates how to set up the socket.
        // http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
        // If you don't understand what this code is doing:
        //    (a) STOP
        //    (b) Review the I/O Streams readme.txt and sample code posted on GitHub
        //        https://github.com/kurmasz/CS371_SampleCode/tree/master/IOStreams
        //    (c) Ask questions.

        // (4) Send the GET request and the other request headers

        // Use the example client request on this page as a sample:
        // https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol
        // (Go to the page and look for the section named "Example Session")
        //   (a) Remember that you need both the "GET" request and the "host" request header.
        //       The cis web server won't respond without both.
        //   (b) Don't forget to end with a blank line and flush the output stream.


        // (5) Read data from the socket until you get a blank line.
        //     Write each line you receive to System.out

        // (6) Create a FileOutputStream object.

        // (7) Read the rest of the data from the socket and write it to a file using
        //     the FileOutputStream you just created.
        //     (Hint:  readLine() returns null when there is no more data to read.)

    } // end main

} // end class

//