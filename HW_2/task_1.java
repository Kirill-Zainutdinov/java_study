package HW_2;

import java.util.Scanner;

import netscape.javascript.JSObject;

public class task_1 {
    public static void main(String[] args){
        Scanner iScanner = new Scanner(System.in);
        
        String str = iScanner.nextLine();
        StringBuilder request = creaqteRequest(str);
        System.out.println(request);
        
        iScanner.close();
    }
//"name":"Ivanov", "country":"Russia", "age":"null", "city":"Moscow"
    public static StringBuilder creaqteRequest(String jsonString){
        StringBuilder request = new StringBuilder("select * from students where ");

        int indexStart = 0;
        int indexEnd = 0;
        char c = '\"';
        while (indexStart < jsonString.length() - 1){
            // получаем индексы начала и конца ключа
            indexStart = jsonString.indexOf(c, indexStart) + 1;
            indexEnd = jsonString.indexOf(c, indexStart);
            // получаем сам ключ
            String key = jsonString.substring(indexStart, indexEnd);
            // получаем индексы начала и конца значения
            indexStart = indexEnd + 1;
            indexStart = jsonString.indexOf(c, indexStart) + 1;
            indexEnd = jsonString.indexOf(c, indexStart);
            // получаем само значение
            String value = jsonString.substring(indexStart, indexEnd);
            // если значение на null - добавляем в запров
            if(!value.equalsIgnoreCase("null")){
                request.append(key + " = \"" + value + "\" AND ");
            }
            indexStart = indexEnd + 1;
        }
        // убираем AND в конце, если есть, а он скорее всего есть
        if (request.lastIndexOf("AND ") == request.length() - 4){
            request = new StringBuilder(request.substring(0, request.length() - 4)) ;
        }
        return request;
    }
}
