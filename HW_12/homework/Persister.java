package homework;

public class Persister implements IPersister{
    public void save(User us){
        System.out.println("Save user: " + us.getName());
    }
}

// Идея такая:
// 1. есть интерфейс калькулятора - типа элементарные операции
// 2. есть сам калькулятор - там реализация этих интерфейсов
// 3. потом есть интерфейс логирования
// 4. есть сам логгер 
// 5. есть view который общается с пользователем, типа что подать да принести
