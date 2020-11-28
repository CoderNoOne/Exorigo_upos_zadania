
--prostsza wersja

select coalesce(max(BatchNumber) + 1, 1)
from ExportBatch;

-- coalesce zwraca pierwszą nienullową wartość

-- zadaniem tego query jest wyswietlenie id o największej wartości dla podanej tabeli powiększonej o 1 - czyli moze zostać użyte jeżeli kolumna z kluczem głównym nie intekrementuje się automatycznie (służy wtedy do wyznaczenia id następnego wstawianego do tabeli rekordu)
