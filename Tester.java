/*
*
* Purpose: Print a contacts list with various sorting and searching methods.
* Author: Madeline Vande Hey
* Date: 4/5/22
*
*/
public class Tester {
    public static void main(String args[]){
        Contact[] contacts = new Contact[10];
        Contact[] empty = new Contact[10];
        // String name, String relation, String birthday, String phoneNum, String email
        contacts[0] = new Contact("Regina George", "Friend", "Nov 12", "(424)167-1123", "meangirl01@gmail.com");
        contacts[1] = new Contact("Cady Heron", "Friend", "Oct 03", "(424)233-3344", "ilovemath@hotmail.com");
        contacts[2] = new Contact("Elle Woods", "Aunt", "Jun 15", "(424)449-0045", "legallyblonde@icloud.com");
        contacts[3] = new Contact("Andrea Sachs", "Aunt", "Jul 12", "(718)528-9090", "devilwearsprada@hotmail.com");
        contacts[4] = new Contact("Mia Thermopolis", "Cousin", "Oct 17", "(788)678-9078", "princessofgenovia@royalfamily.com");
        contacts[5] = new Contact("Barry Benson", "Uncle", "Aug 05", "(560)934-5640", "beelawyer@gmail.com");
        contacts[6] = new Contact("Fred Jones", "Dad", "Jun 10", "(788)902-2471", "iliketraps@hotmail.com");
        contacts[7] = new Contact("Daphne Blake", "Mom", "Jan 06", "(788)890-0988", "daphneblake@gmail.com");
        contacts[8] = new Contact("Harry Potter", "Uncle", "May 10", "(446)187-0327", "hpotter@gmail.com");
        contacts[9] = new Contact("Hermoine Granger", "Friend", "Sep 14", "(321)559-1862", "hgranger@icloud.com");

        print(contacts);

        sortByName(contacts, empty);

        sortByRelation(contacts, empty);

        insertionName(contacts);
        binarySearchName(contacts, "Regina George");
        binarySearchName(contacts, "Olivia Rodrigo");

        insertionRelation(contacts);
        binarySearchRelation(contacts, "Aunt");
        binarySearchRelation(contacts, "Grandma");

        searchByMonth(contacts, "January");
        searchByMonth(contacts, "March");

        searchByPhone(contacts, "(321)559-1862");
        searchByPhone(contacts, "(920)445-9098");

        searchByEmail(contacts, "legallyblonde@icloud.com");
        searchByEmail(contacts, "ilikerobots@gmail.com");
    }

    public static void print(Contact[] contacts){
        System.out.printf("%48s\n", "Contacts List");
        System.out.println();
        System.out.printf("%-18s %-11s %-11s %-16s %-15s", "Name", "Relation", "Birthday", "Phone #", "Email");
        System.out.println("\n-----------------------------------------------------------------------------------------------");
        for(Contact c : contacts){
            System.out.println(c.toString());
        }

    }

    public static void sortByName(Contact[] source, Contact[] dest){
        for(int i = 0 ; i < source.length ; i++){
            Contact next = source[i];
            int insertIndex = 0;
            int k = i;

                while(k > 0 && insertIndex == 0){
                    if(next.getName().compareTo( dest[k-1].getName() ) > 0) insertIndex = k;
                    else dest[k] = dest[k - 1];
                    k--;
                }

                dest[insertIndex] = next;
            }
            System.out.println("\n<< Sorting by name alphabetically >>\n");
            print(dest);
    }

    public static void sortByRelation(Contact[] source, Contact[] dest){
        for(int i = 0 ; i < source.length ; i++){
            Contact next = source[i];
            int insertIndex = 0;
            int k = i;

                while(k > 0 && insertIndex == 0){
                    if(next.getName().compareTo( dest[k-1].getRelation() ) > 0) insertIndex = k;
                    else dest[k] = dest[k - 1];
                    k--;
                }

                dest[insertIndex] = next;
            }

            System.out.println("\n<< Sorting by relation alphabetically >>\n");
            print(dest);
    }

    // searches array for relation
    public static void binarySearchName(Contact[] m, String toFind){
        System.out.println("\n<< Searching for " + toFind + " >>\n");

        int high = m.length;
        int low = -1;
        int probe;

        while(high - low > 1){
            probe = ( high + low ) / 2;

            if(m[probe].getName().compareTo(toFind) > 0){
                high = probe;
            }
            else{
                low = probe;
                if(m[probe].getName().compareTo(toFind) == 0){
                    break;
                }
            }
        }
        
        if( (low >= 0) && (m[low].getName().compareTo(toFind) == 0 )){
            System.out.println("Found:");
            linearPrintName(m, low, toFind);
        }
        else{
            System.out.println("NOT found: " + toFind);
        }

    }

    // methods to assist w/ printing binary search
    public static void linearPrintName(Contact[] r, int low, String toFind){
        int i;
        int start = low;
        int end = low;

        // find starting point of matches
        i = low - 1;
        while((i >= 0) && (r[i].getName().compareTo(toFind) == 0)){
            start = i;
            i--;
        }

        // find ending point of matches
        i = low + 1;
        while((i < r.length) && (r[i].getName().compareTo(toFind) == 0)){
            end = i;
            i++;
        }

        // now print out the matches
        for(i = start; i <= end; i++){
            System.out.println(r[i]);
        }
    }

    public static void insertionName(Contact[] source){
        Contact[] dest = new Contact[ source.length ];

        for( int i = 0 ; i < source.length ; i++ ){
            Contact next = source[i];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 ){
                if(next.getRelation().compareTo(dest[k-1].getName()) > 0){
                    insertIndex = k;
                }
                else{
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[insertIndex] = next;
            
            // debugging statements 
            /*System.out.println("\nPass # " + i);
            for(Music m : dest){  
                if(m != null) System.out.printf("%-10s \n", m.getArtist());
            }*/
        }
        
        for(int i = 0; i < dest.length; i++){
            source[i] = dest[i];
        }
    }
    
    // searches array for relation
    public static void binarySearchRelation(Contact[] m, String toFind){
        System.out.println("\n<< Searching for relation: " + toFind + " >>\n");

        int high = m.length;
        int low = -1;
        int probe;

        while(high - low > 1){
            probe = ( high + low ) / 2;

            if(m[probe].getRelation().compareTo(toFind) > 0){
                high = probe;
            }
            else{
                low = probe;
                if(m[probe].getRelation().compareTo(toFind) == 0){
                    break;
                }
            }
        }
        
        if( (low >= 0) && (m[low].getRelation().compareTo(toFind) == 0 )){
            System.out.println("Found:");
            linearPrintRelation(m, low, toFind);
        }
        else{
            System.out.println("NOT found: " + toFind);
        }

    }

    // methods to assist w/ printing binary search
    public static void linearPrintRelation(Contact[] r, int low, String toFind){
        int i;
        int start = low;
        int end = low;

        // find starting point of matches
        i = low - 1;
        while((i >= 0) && (r[i].getRelation().compareTo(toFind) == 0)){
            start = i;
            i--;
        }

        // find ending point of matches
        i = low + 1;
        while((i < r.length) && (r[i].getRelation().compareTo(toFind) == 0)){
            end = i;
            i++;
        }

        // now print out the matches
        for(i = start; i <= end; i++){
            System.out.println(r[i]);
        }
    }

    public static void insertionRelation(Contact[] source){
        Contact[] dest = new Contact[ source.length ];

        for( int i = 0 ; i < source.length ; i++ ){
            Contact next = source[i];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 ){
                if(next.getRelation().compareTo(dest[k-1].getName()) > 0){
                    insertIndex = k;
                }
                else{
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[insertIndex] = next;
            
            // debugging statements 
            /*System.out.println("\nPass # " + i);
            for(Music m : dest){  
                if(m != null) System.out.printf("%-10s \n", m.getArtist());
            }*/
        }
        
        for(int i = 0; i < dest.length; i++){
            source[i] = dest[i];
        }
    }

    // sequential searching
    public static void searchByMonth(Contact[] contacts, String search){
        boolean found = false;
        System.out.println("\n << Searching for contacts born in " + search + " >> \n");
        for(Contact c : contacts){
            if(c.getBirthday().contains(search.substring(0,3))){
                if(found == false){
                    System.out.println("Found:");
                    found = true;
                }
                System.out.println(c.toString());
            }
        }
        if(found == false) System.out.println("NOT found: " + search);
    }

    public static void searchByPhone(Contact[] contacts, String search){
        boolean found = false;
        System.out.println("\n << Searching for contacts with the phone number " + search + " >> \n");
        for(Contact c : contacts){
            if(c.getPhoneNum().equals(search)){
                if(found == false){
                    System.out.println("Found:");
                    found = true;
                }
                System.out.println(c.toString());
            }
        }
        if(found == false) System.out.println("NOT found: " + search);
    }

    public static void searchByEmail(Contact[] contacts, String search){
        boolean found = false;
        System.out.println("\n << Searching for contacts with the email " + search + " >> \n");
        for(Contact c : contacts){
            if(c.getEmail().equals(search)){
                if(found == false){
                    System.out.println("Found:");
                    found = true;
                }
                System.out.println(c.toString());
            }
        }
        if(found == false) System.out.println("NOT found: " + search);
    }


}
