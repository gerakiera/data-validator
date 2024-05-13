# Валидатор данных
Валидотор данных- это библиотека, реализующая проверку данных по заданным критериям. Настроены проверки для трёх типов данных:  
-строка (String)  
-целое число (Integer)  
-коллекция (Map)  

Чтобы воспользоваться валидатором, необходимо создать объект данной программы.
`var v = new Validator();`
Далее необходимо создать и настроить схему проверки данных. Для разных типов данных- разные схемы.
## Валидация строк
`var schema = v.string();`
Вызов метода string() создает схему StringSchema, которая включает в себя методы:
- *required()* — строка не додлжна быть пустой
- *minLength()* — строка должна быть равна или длиннее заданного числа
- *contains()* — строка должна содержать определённую подстроку
После настройки схемы валидации необходимо вызвать метод isValid() для проверки данных.

### Пример:
```
Validator v = new Validator();
StringSchema schema = v.string();

schema.required().isValid(""); //false
schema.minLength(6).isValid("hello"); //false
schema.contains("for").isValid("text for test"); // true
```
## Валидация чисел
`var schema = v.number();`
Вызов метода number() определяет схему NumberSchema, которая содержит методы:
- *required()* — значение не должно быть null
- *positive()* — число должно быть положительным
- *range()* — значение числа должно попадать в диапазон, включая границы
После настройки схемы валидации необходимо вызвать метод isValid() для проверки данных.

### Пример:
```
Validator v = new Validator();
NumberSchema schema = v.number();

schema.required().isValid(null); //false
schema.positive().isValid(5); // true
schema.range(5, 6).isValid(4); //false
```
## Валидация объектов типа Map
`var schema = v.map();`
Вызов метода map() определяет схему MapSchema, которая содержит следующие методы:
- *required()* — требуется тип данных Map
- *sizeof()* — количество пар ключ-значений в объекте Map должно быть равно заданному
После настройки схемы валидации необходимо вызвать метод isValid() для проверки данных.

### Пример:
```
Validator v = new Validator();
MapSchema schema = v.map();

schema.required().isValid(new HashMap<>()); //true

Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(3);

schema.isValid(data);  // false
data.put("key2", "value2");
data.put("key3", "value3");
schema.isValid(data); // true
```
## Вложенная валидация
В проекте реализована проверка данных внутри объектов Map с помощью валидатора shape(). 
После настройки схемы валидации необходимо вызвать метод isValid() для проверки данных.

### Пример:
```
Validator v = new Validator();
MapSchema schema = v.map();

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));
schemas.put("age", v.number().required().positive());

schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
human1.put("age", 30);
schema.isValid(human1); //true

Map<String, Object> human2 = new HashMap<>();
human2.put("firstName", "Anna");
human2.put("lastName", "B");
human2.put("age", -5);
schema.isValid(human2); //false

Map<String, Object> human3 = new HashMap<>();
human3.put("firstName", "Bob");
human3.put("lastName", null);
human3.put("age", 45);
schema.isValid(human3); //false
```


### Hexlet tests and linter status:
[![Actions Status](https://github.com/gerakiera/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/gerakiera/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/1147fac41d86537806c5/maintainability)](https://codeclimate.com/github/gerakiera/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/1147fac41d86537806c5/test_coverage)](https://codeclimate.com/github/gerakiera/java-project-78/test_coverage)
[![Java CI](https://github.com/gerakiera/java-project-78/actions/workflows/gradle.yml/badge.svg)](https://github.com/gerakiera/java-project-78/actions/workflows/gradle.yml)
