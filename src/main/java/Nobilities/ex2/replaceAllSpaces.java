

package Nobilities.ex2;
public class replaceAllSpaces {

    public static void main(String[] args) {
        String txt = "Ala ma kota";
        String txt2 = txt.replace(" ", "%20");
        System.out.println(txt2);
        String txt3 = txt.replace(" ","@_@");
        System.out.println(txt3);
        txt3 = txt.replace('a','A');
        System.out.println(txt3);
    }
}
