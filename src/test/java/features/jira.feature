#language: ru

@TEST
  @Epic(value="smh")
  @Feature(value="Проверка")
  @Story(value="Сложение")
  @Test
  Функция: выведение статуса задачи
    Структура сценария:логин в системе, вывод статуса и версии
      Дано логин '<login>', пароль '<pass>', имя задачи '<TaskName>'
      Тогда логин в системе
      Затем вывод статуса и версии

      Примеры:
        | login    | pass      | TaskName     |
        | slevicky | Qwerty123 | TestSelenium |
