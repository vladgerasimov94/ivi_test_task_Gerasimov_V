# ivi_test_task_Gerasimov_V

Инструкция по установке и запуску:

1. Скачать и установить jdk 8:

	* Для загрузки с оф. сайта потребуется регистрация
	- Необходимо выбрать нужную версию на оф. сайте: https://www.oracle.com/technetwork/java/javase/downloads/2133151
	- Выбрать Accept License Agreement = True и скачать jdk 8

2. Настроить переменные среды:

Для Windows:
	- Перейти в: Сведения о системе -> Доп параметры -> Дополнительно -> Переменные среды
	- Создать переменную JAVA_HOME в системных переменных:
		Имя: JAVA_HOME 
		Значение: <Указать путь к папке с jdk>
	- Найти переменную Path в Системных переменных, выбрать Изменить -> Создать
	- Добавить адрес к папке bin <Указать путь к папке с jdk\bin>
	- Сохранить изменения

Для проверки правильности установки:
	- Открыть командную строку
	- Ввести команду "java -version"
	- Убедиться, что в консоли указана установленная версия 1.8

3. Установить сборщик Gradle и настроить переменные среды:

	- Скачать с оф. сайта gradle "https://gradle.org/next-steps/?version=6.0.1&format=all" архив
	- распаковать в любую папку


Настроить переменные среды для Gradle:

Для Windows:
	- Перейти в: Сведения о системе -> Доп параметры -> Дополнительно -> Переменные среды
	- Создать переменную GRADLE_HOME в системных переменных:
		Имя: GRADLE_HOME 
		Значение: <Указать путь к папке с gradle>
	- Найти переменную Path в Системных переменных, выбрать Изменить -> Создать 
	- Добавить адрес к папке bin <Указать путь к папке с gradle\bin>
	- Сохранить изменения

Для проверки правильности установки:
	- Открыть командную строку
	- Ввести команду "gradle -version"
	- Убедиться, что в консоли указана установленная версия

3. Установить среду разработки IntelliJ Idea:

Загрузить с оф. сайта: "https://www.jetbrains.com/ru-ru/idea/"

4. Клонировать проект из GitHub:

	- Если Git не установлен:
		- Скачать Git Desktop с оф. сайта
	- Клонировать репозиторий по URL: "https://github.com/vladgerasimov94/ivi_test_task_Gerasimov_V.git"

5. Запустить проект в Intellij Idea:
	- Выбрать Open priject
	- Выбрать директорию с клонированным из Git проектом

----------------------------------------------------------------------------------------------------------------------------------
		Запустить все тесты сразу можно из Test Suite "testng.xml" (src\main\test\resourses), а также отдельно в тестовых классах.
----------------------------------------------------------------------------------------------------------------------------------
