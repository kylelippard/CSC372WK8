import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String name = "";
        String address = "";
        double gpa = 0.0;
        boolean isInt = false;
        boolean isDouble = false;
        File file = new File("log.txt");


        LinkedList<Student> students = new LinkedList<Student>();
        int i = 0;

        while(!isInt){
            try {
                System.out.println("Please enter how many students need to be added to the LinkedList.");
                i = myObj.nextInt();
                isInt = true;
                if(i <=0 ){
                    throw new Exception("Invalid input.");
                }
            } catch (Exception e) {
               // valid = false;
                System.out.println("Invalid Input.");
                myObj.next();
                continue;

            }
        }

        for (int j = 0; j < i; j++) {
            isDouble = false;
            System.out.println("What is the student's name? : ");
            name = myObj.next();
            myObj.nextLine();
            System.out.println("What is the student's address? : ");
            address = myObj.next();
            myObj.nextLine();

            while(!isDouble){
                try {
                    System.out.println("What is the student's GPA? :");
                    gpa = myObj.nextDouble();
                    isDouble = true;
                    if(gpa <=0 ){
                        throw new Exception("Invalid input.");
                    }
                } catch (Exception e) {
                    // valid = false;
                    System.out.println("Invalid Input.\nWhat is the student's GPA? :");
                    myObj.next();
                    continue;
                }
            }
            students.add(new Student(name, address, gpa));
            myObj.nextLine();

        }
        String studentOutput = "";
        try {//try catch block to handle io exceptions.
            //creates a new instance of the FileWriter Class, w/ assigned file name of log.txt, any saved text will be appended to the end.
            FileWriter fw = new FileWriter("log.txt", true);
            fw.append("NewLine");
            for(Student s : students){
                //outputs the contents of textArea to the file.
                //studentOutput = s.toString();
                try (FileOutputStream fos = new FileOutputStream(file);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(s.toString());
                    oos.flush();
                }
            }


            //popup to notify that file is saved.
        } catch (IOException ex) {

            throw new RuntimeException(ex);
        }


    }
}