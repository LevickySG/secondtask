#language: ru
@TEST
Функция:создание новой задачи и закрытие
  Структура сценария:Открыть сценарий, закрыть сценарий
    Дано логин '<login>', пароль '<pass>', имя задачи '<TaskName>', описание '<TaskDescription>', окружение '<TaskEnv>', версия '<TaskVer>'
    Тогда логин в системе
    Затем создание задачи и закрытие задачи

    Примеры:
      | login|pass|TaskName|TaskDescription|TaskEnv|TaskVer|
      |slevicky|Qwerty123|DefaultTask|DefaultDescription|DefaultEnv|Version 2.0|
