package dev.manu.dsa.ArraysAndStrings;

public class StringOperations {
    static void main() {
        System.out.println(MyStingBuilders());
    }
    public static String MyStingBuilders() {
        StringBuilder sb = new StringBuilder();
        String[] langs = {"Java","GO","Rust","Python","C#","TypeScript"};
        for(String lang : langs) {
            sb.append(lang).append(" ");
        }
        String result = sb.toString().trim();
        return result;
    }
}
