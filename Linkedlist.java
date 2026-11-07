public class Linkedlist {
public static void main(String[] args) {
    String name="computer";
    String brand="";
    int left=0;
    // int right=name.length-1;

    for(int i=name.length()-1;i>=0;i--){
        brand=brand+name.charAt(i);
    }
    System.out.println(brand);
}
}
