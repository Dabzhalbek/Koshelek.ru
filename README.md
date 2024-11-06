# Koshelek.ru

## Требования для запуска проекта 
Программное обеспечение
Java Development Kit (JDK):

Необходима версия Java 11 или выше для корректной работы проекта.
Скачать JDK можно с официального сайта Oracle.
Git:

Для клонирования репозитория необходим установленный Git.
Скачать Git можно с официального сайта.
Maven:

Для сборки и запуска тестов требуется Apache Maven 3.x.
Установить Maven можно, следуя инструкциям на официальном сайте Maven.
IDE (необязательно, но рекомендуется):

Для удобной работы с проектом рекомендуется использовать IntelliJ IDEA или любую другую Java-IDE с поддержкой Maven.
В IntelliJ IDEA настройка Maven и Java обычно происходит автоматически после открытия проекта.
Интернет-соединение:

Требуется для скачивания зависимостей Maven и клонирования репозитория.

### Запуск тестов

Проект имеет две ветки: `main` и `main-with-jar`. Каждая содержит свои инструкции по запуску тестов.

### Ветка main
1. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/Dabzhalbek/Koshelek.ru.git
    ```
   Можете сделать это с помощью IDE (Intellij IDEA подойдет лучше всех) 
2. Убедитесь, что установлена Java и Maven. 
   ```bash 
      java -version
      mvn -version
   ```
3. Откройте проект с помощью IDE и запустите класс RegistrationPageTest
ИЛИ 
Запустите тесты командой:
    ```bash
    mvn test
    ```
### Ветка main-with-jar

1. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/Dabzhalbek/Koshelek.ru.git
    ```
2. Если уже склонировали то перейдите на ветку main-with-jar
3. ```bash
   git checkout main-with-jar
   ```
4. Убедитесь, что установлена Java.
5. Запустите класс Main через IDE
ИЛИ
6. Соберите и запустите JAR файл:
    ```bash
    mvn clean
    mvn package
    java -jar target/Koshelek-1.0-SNAPSHOT.jar
    ```
   Примечание: Чтобы остановить выполнение JAR-файла, используйте команду Ctrl + C в терминале.
