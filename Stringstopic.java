public class Stringstopic {
public static void main(String[] args) {
    String userName="meghana";
    char value='a';
    int count=0;
    for(int i=0;i<userName.length();i++){
        if(userName.charAt(i)==value){
            count++;
        }
    }
    System.out.println(count);
    // for(int i=0;i<userName.length();i++){
    //     System.out.println(userName.charAt(i));
    // }
    // System.out.println(userName.length());
}
}
