#language: ru

@TEST

  Функция:проверка количества задач, выведение статуса задачи
    Структура сценария:логин в системе, вывод статуса и версии
      Дано логин '<login>', пароль '<pass>', имя задачи '<TaskName>'
      Тогда логин в системе
      Затем вывод статуса и версии

      Примеры:
        | login    | pass      | TaskName     |
        | slevicky | Qwerty123 | TestSelenium |


Функция:создание новой задачи и закрытие
  Структура сценария:Открыть сценарий, закрыть сценарий
    Дано логин '<login>', пароль '<pass>', имя задачи '<TaskName>', описание '<TaskDescription>', окружение '<TaskEnv>', версия '<TaskVer>'
    Тогда логин в системе
    Затем создание задачи и закрытие задачи

    Примеры:
      | login|pass|TaskName|TaskDescription|TaskEnv|TaskVer|
      |slevicky|Qwerty123|TestSelenium|DefaultDescription|DefaultEnv|Version 2.0|
