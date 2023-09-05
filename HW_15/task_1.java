package HW_15;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;

// Дико извиняюсь, что не сделал нормальной декомпозиции по классам
// катастрофически не хватает времени...

// примеры для входных данных
// Ivanov f Ivan 10.10.1010 Ivanovich 12345
// f Petrov 12.12.1212 Petr Petrovich 45678

public class task_1 {
    
    public static void main(String[] args){
        try {
            write(find(split(read())));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так:");
            System.out.println(e);
        }
    }

    public static String read(){
        System.out.println("Введите в одну строку следующие данные в указанном порядке:");
        System.out.println("Фамилию Имя Отчество");
        System.out.println("Дату рождения в формате dd.mm.yyyy");
        System.out.println("Телефон - только цифры без какого-либо форматирования");
        System.out.println("Пол - один символ f или m");
        System.out.println("Если вы введёте данные в неправильном формате, то всё сломается");
        System.out.println("Вы можете ввести данные не в указанном порядке, но тогда могут не правильно определится ФИО");
        System.out.println("Вообще можете делать, что хотите, но мы предупредили");
        Scanner iScanner = new Scanner(System.in);
        String str = iScanner.nextLine();
        iScanner.close();
        return str;
    }

    public static String[] split(String str){
        String[] data = str.split(" ");
        if (data.length > 6){
            throw new RuntimeException("Данных больше, чем нужно");
        } else if (data.length < 6) {
            throw new RuntimeException("Данных меньше, чем нужно");
        }
        return data;
    }

    public static String find(String[] data) {
        int check = 0;
        String name = "",
            surname = "",
            lastname = "",
            date = "",
            phone = "",
            male = "";
        for (int i = 0; i < data.length; i++){
            if( surname.length() == 0 && checkName(data[i])){
                surname = data[i];
                check++;
            }
            else if(surname.length() != 0 && name.length() == 0 && checkName(data[i])){
                name = data[i];
                check++;
            }
            else if(surname.length() != 0 && name.length() != 0 && lastname.length() == 0 && checkName(data[i])){
                lastname = data[i];
                check++;
            }
            else if(date.length() == 0 && checkDate(data[i])){
                date = data[i];
                check++;
            }
            else if(phone.length() == 0 && checkPhone(data[i])){
                phone = data[i];
                check++;
            }
            else if(male.length() == 0 && checkMale(data[i])){
                male = data[i];
                check++;
            }
        }
        if (check == 6){
            return new String(surname + " " + name + " " + lastname + " " + date + " " + phone + " " + male);
        } else {
            String ErrorMessage = "";
            if (surname.length() == 0 || name.length() == 0 || lastname.length() == 0){
                ErrorMessage += " ФИО";
            }
            if (date.length() == 0){
                ErrorMessage += " дата рождения";
            }
            if (phone.length() == 0){
                ErrorMessage += " телефон";
            }
            if (male.length() == 0){
                ErrorMessage += " пол";
            }
            throw new RuntimeException("Вы ввели следующие данные в неправильном формате:" + ErrorMessage + ". Мы же предупреждали... ");
        }
    }

    public static boolean checkName(String str) {
        boolean result = 'A' <= str.charAt(0) && str.charAt(0) <= 'Z';
        if (result) {
            for (int i = 1; i < str.length(); i++) {
                if(!('a' <= str.charAt(i) && str.charAt(i) <= 'z')){
                    result = false;
                    break;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static boolean checkDate(String str) {
        boolean result = str.length() == 10;
        if (result) {
            result = str.charAt(2) == '.' && str.charAt(5) == '.';
            if (result) {
                try {
                    int dd = Integer.parseInt((str.substring(0, 2)));
                    result = 1 <= dd && dd <= 31;
                } catch (Exception e) {
                    return false;
                }
                try {
                    int mm = Integer.parseInt((str.substring(3, 5)));
                    result = 1 <= mm && mm <= 12;
                } catch (Exception e) {
                    return false;
                }
                try {
                    int yyyy = Integer.parseInt((str.substring(6, 10)));
                    result = 1 <= yyyy && yyyy <= 9999;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return result;
    }

    public static boolean checkMale(String str) {
        return str.equals("m") || str.equals("f");
    }

    public static boolean checkPhone(String str) {
        if('0' <= str.charAt(0) && str.charAt(0) <= '9')
        {
            try {
                Integer.parseInt(str);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void write(String str) {
        try(FileWriter writer = new FileWriter("database.txt", true)) { 
            writer.write(str + "\n");
        } 
        catch(IOException e){ 
            throw new RuntimeException("Проблемы с записью в файл " + e);
        } 
    }
}
