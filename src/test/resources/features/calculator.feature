#language: ru

@TEST

  Функция: Test. Подсчёт суммы двух чисел.

    @001Step
    Сценарий: 001.1 Получение числа x
      Когда Пользователь вводит x

    @002Step
    Сценарий: 002.1 Получение числа y
      Когда Пользователь вводит y
    @003Step
    Сценарий: 003.1 Получение суммы x и y
      Тогда Получить сумму

    @004Step
      Сценарий: 004.1 Вывод результата
        Затем Вывести результат
