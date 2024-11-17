-- Insert data into IT_Service_Catalog
INSERT INTO DBADMIN.IT_Service_Catalog (service_name)
VALUES
    ('Поддержка волоконно-оптических линий связи');





-- Insert data into Request_Types linked to the appropriate service
INSERT INTO DBADMIN.Request_Types (service_id, type_name)
VALUES
    ((SELECT service_id FROM IT_Service_Catalog WHERE service_name = 'Поддержка волоконно-оптических линий связи'), 'Восстановление ВОЛС');
INSERT INTO DBADMIN.Request_Types (service_id, type_name)
VALUES
    ((SELECT service_id FROM IT_Service_Catalog WHERE service_name = 'Поддержка волоконно-оптических линий связи'), 'Ремонт оборудования ВОЛС');
INSERT INTO DBADMIN.Request_Types (service_id, type_name)
VALUES
    ((SELECT service_id FROM IT_Service_Catalog WHERE service_name = 'Поддержка волоконно-оптических линий связи'), 'Решение инцидентов в работе ВОЛС');




-- Вставка данных в таблицу Locations с указанием id
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (1, 'в 30 км к западу от г. Жезказган', 'Улытауская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (2, 'Жезказганский регион', 'Улытауская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (4, 'Жанааркинский район, в 130 км к юго-востоку от г. Жезказган', 'Карагандинская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (6, 'промзона в 30-40км от г.Сатпаева', 'Улытауская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (8, 'промзона г. Сатпаев', 'Улытауская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (10, 'в 10 км севернее г. Темиртау', 'Карагандинская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (11, 'рудник "Абыз"', 'Карагандинская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (12, 'ВКО, Аягузский район', 'Восточно-Казахстанская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (13, 'г. Балхаш', 'Карагандинская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (14, 'Жамбылская область, г. Шу', 'Жамбылская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (15, '15км от г. Балхаш, микрорайон Коунрад', 'Карагандинская область');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (16, 'Каркаралинский район, пос. Карагайлы', 'Карагандинская область');

INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (3, 'Данные не были предоставлены', 'Данные не были предоставлены');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (5, 'Данные не были предоставлены', 'Данные не были предоставлены');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (7, 'Данные не были предоставлены', 'Данные не были предоставлены');
INSERT INTO DBADMIN.Locations (location_id, address, region)
VALUES
    (9, 'Данные не были предоставлены', 'Данные не были предоставлены');



-- Вставка данных в таблицу AdministrativeObjects
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Северо-Жезказганский рудник (СЖР)', 3);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Рудник Кусмурын-Акбастау', 12);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Рудник Конырат', 15);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Карагайлинская ОФ (КОФ)', 16);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Нурказганская ОФ (НОФ)', 10);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('ЖОФ №3', 8);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Рудник Абыз', 11);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Рудник Западный', 5);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Балхашская ОФ (БОФ)', 13);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Восточно-Жезказганский рудник (ВЖР)', 2);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Рудник Шатыркуль', 14);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Рудник Нурказган', 10);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Южно-Жезказганский рудник (ЮЖР)', 1);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('ЖОФ №1, №2', 7);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Рудник Саяк', 13);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Рудник Жомарт', 4);
INSERT INTO DBADMIN.AdministrativeObjects (name, location_id)
VALUES
    ('Жиландинский рудник', 6);


-- Вставка данных в таблицу ProductionObjects
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта №57', 2);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта Анненская', 2);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта №65', 1);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта Саяк - 1', 13);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта Шатыркуль', 14);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта №55', 2);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта №73/75', 5);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта №67', 5);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта Абыз', 11);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта Нурказган', 10);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта Жомарт', 4);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта Жыланды', 6);
INSERT INTO DBADMIN.ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта Кусмурын-Акбастау', 12);




-- Вставка данных в таблицу Horizons
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт "+220м"', 1);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт "+180 м"', 1);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт "+90м"', 1);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Дозатор Горизонт "-20м"', 1);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Зумпф Горизонт "-80м"', 1);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +170', 2);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +90', 2);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +75', 2);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -50', 2);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -90', 2);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -230', 2);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -275', 2);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +140', 3);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 235 шахта 45', 3);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 305 шахта 45', 3);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 305, 235 шахта 45', 3);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 100', 3);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 140', 3);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 30', 3);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 206', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 490', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 491', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 187', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 160', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Транспортный уклон горизонт №4 горизонт 314', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Транспортный уклон горизонт №3 горизонт 345', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 125', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 507', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 520', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 460', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 470', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 485', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Сопряжение на портал 355 горизонт 310', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 240', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Транспортный уклон горизонт №2 горизонт 394', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Портал горизонт 450', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Транспортный уклон горизонт №1 428', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 447', 4);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Транспортный уклон №3 гор. 850', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Портал №2 Штрек 2 горизонт 840', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Съезд на горизонт 780', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 760', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Штрек 3 горизонт 800', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Штрек 3 горизонт 740', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Штрек 3 горизонт 720', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Штрек 3 горизонт 680', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Штрек 3 горизонт 620', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Штрек 3 горизонт 560', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Штрек 3 горизонт 520', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Штрек 3 горизонт 500', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Штрек 3 горизонт 440', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Штрек 3 горизонт 380', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Транспортный уклон №1 гор. 780', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 625', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 640', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 540', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 680', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Портал №6 Съезд на горизонт 800', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Портал №6 Съезд на горизонт 840', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Портал №6 Съезд на горизонт 860', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Портал №3 контейнер гор. 905', 5);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 265 м', 6);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 220 м', 6);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 180 м', 6);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 18 м', 6);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 300 м Западный портал', 6);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Поверхность', 7);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Нулевая отметка', 7);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Ствол шахты', 7);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -20', 7);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -90', 7);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -128', 7);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -205', 7);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -257', 7);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -60', 7);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -60', 8);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +60', 8);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +30', 8);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -20', 8);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -140', 8);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -125', 8);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -240', 8);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -175', 8);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +20', 8);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +100', 8);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +640', 9);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +590', 9);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +490', 9);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +457', 9);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +406', 9);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +390', 9);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +440', 9);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Портал', 10);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Конвейерный уклон 1', 10);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Транспортный уклон №1', 10);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +300', 10);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +280', 10);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +320', 10);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Транспортный уклон №2', 10);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +275', 10);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт +245', 10);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт -190', 11);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Устье портала', 12);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 300', 12);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 200', 12);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 150', 12);
INSERT INTO DBADMIN.Horizons (name, production_object_id)
VALUES
    ('Горизонт 0', 12);


--optical
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи от TORO сервис до ГСМ', 13);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи от САТ сервис до TORO сервис', 13);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до КМС 1', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта 55 от ГСМ до участка № 54', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до участка № 55', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до склада ВМ', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта 55 от участка 55 до ГСМ', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта Анненская гор -50 м от АТС через отм -5 м до склада ВМ', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения, через отм 16 до 0 отметки на гора по стволу на руддвор горизонт 220 м шахта 57', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта Анненская гор -90 м от АТС через отм -5 м до гор -50м, КМС 2 (Торо Сервис)', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до гаража связи', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта Анненская гор -50 м от АТС через отм -5 м до ГСМ', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта Анненская гор -90 м от АТС через отм -5 м до КМС 1 (Сат Сервис)', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта Анненская от АТС через отм -5 м, по стволу до гор -90 м на руддвор, через руддвор до гаража связи', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до руддвора гор 265 м', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР от руддвор горизонт 220м по стволу до гор 90 м ЦРП шахта 57', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения до ВМ склад горизонт 220м шахта 57', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР от ВМ склад горизонт 220м до гаража связи горизонт 220м шахта 57', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения до КМС1 (Атлас Копко) горизонт 220 шахта 57', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения до КМС 2 (Кат Сервис) горизонт 180м шахта 57', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения до материальный склад горизонт 180 шахта 57', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения до ГСМ на горизонт 180м шахта 57', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта 55 от руддвора гор 265 м по стволу через руддвор гор 180 м до ЦРП', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до КМС 2', 10);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи от AБК (АТС) р.Жомарт до Грузовой р.Жомарт', 16);
INSERT INTO DBADMIN.optical_fiber_lines (name, administrative_object_id) VALUES
    ('Волоконно-оптическая линия связи от Грузовой ствол до Драбилка №4 р.Жомарт', 16);






-- Вставка данных в таблицу Employees
INSERT INTO DBADMIN.Employees (full_name, department, position)
VALUES
    ('Сидоров Алексей Петрович', 'Головной центр телекоммуникаций', 'Мастер участка (сменный)');
INSERT INTO DBADMIN.Employees (full_name, department, position)
VALUES
    ('Кузнецова Мария Ивановна', 'Головной центр телекоммуникаций', 'Мастер участка (сменный)');
INSERT INTO DBADMIN.Employees (full_name, department, position)
VALUES
    ('Смирнов Дмитрий Сергеевич', 'Головной центр телекоммуникаций', 'Мастер участка (сменный)');
INSERT INTO DBADMIN.Employees (full_name, department, position)
VALUES
    ('Лебедева Анна Викторовна', 'Головной центр телекоммуникаций', 'Мастер участка');
INSERT INTO DBADMIN.Employees (full_name, department, position)
VALUES
    ('Федоров Сергей Александрович', 'Головной центр телекоммуникаций', 'Мастер участка (сменный)');



-- Вставка данных в таблицу IncidentCauses
INSERT INTO DBADMIN.incident_causes (name)
VALUES
    ('Хищение/кража');
INSERT INTO DBADMIN.incident_causes (name)
VALUES
    ('Повреждение');
INSERT INTO DBADMIN.incident_causes (name)
VALUES
    ('Отсутствие электропитания');
INSERT INTO DBADMIN.incident_causes (name)
VALUES
    ('Обрыв линии');
INSERT INTO DBADMIN.incident_causes (name)
VALUES
    ('Обрушение/отслоение горной массы');
INSERT INTO DBADMIN.incident_causes (name)
VALUES
    ('Другое');



-- Вставка данных в таблицу AcceptedMeasures
INSERT INTO DBADMIN.AcceptedMeasures (name)
VALUES
    ('Восстановление обрыва');
INSERT INTO DBADMIN.AcceptedMeasures (name)
VALUES
    ('Подбурка кабеля');
INSERT INTO DBADMIN.AcceptedMeasures (name)
VALUES
    ('Прокладка кабеля на поверхности');
INSERT INTO DBADMIN.AcceptedMeasures (name)
VALUES
    ('Перевешивание кабеля на другой борт');
INSERT INTO DBADMIN.AcceptedMeasures (name)
VALUES
    ('Замена кабеля');
INSERT INTO DBADMIN.AcceptedMeasures (name)
VALUES
    ('Спайка/распайка кабеля');
INSERT INTO DBADMIN.AcceptedMeasures (name)
VALUES
    ('Другое');



INSERT INTO DBADMIN.RequestExtensionCauses (name)
VALUES
    ('Перенаправление запроса');
INSERT INTO DBADMIN.RequestExtensionCauses (name)
VALUES
    ('Отсутствие электропитания');
INSERT INTO DBADMIN.RequestExtensionCauses (name)
VALUES
    ('Отсутствие ТМЦ');
INSERT INTO DBADMIN.RequestExtensionCauses (name)
VALUES
    ('Необходимость создания безопасных условий');


-- Вставка данных в таблицу IncidentStatus
INSERT INTO DBADMIN.IncidentStatus (name, note)
VALUES
    ('Решен', NULL);
INSERT INTO DBADMIN.IncidentStatus (name, note)
VALUES
    ('Отклонен', 'Подробная информация отклонения запроса описывается в поле "Решение"');



-- Вставка данных в таблицу RequestStatus
INSERT INTO DBADMIN.RequestStatus (name)
VALUES
    ('Зарегистрирован');
INSERT INTO DBADMIN.RequestStatus (name)
VALUES
    ('Назначен');
INSERT INTO DBADMIN.RequestStatus (name)
VALUES
    ('В работе');
INSERT INTO DBADMIN.RequestStatus (name)
VALUES
    ('Закрыт');



-- Вставка данных в таблицу SupportGroup
INSERT INTO DBADMIN.SupportGroup (name)
VALUES
    ('1-я линия ИТ-Service Desk');
INSERT INTO DBADMIN.SupportGroup (name)
VALUES
    ('2-я линия ИТ-Жезказган');
INSERT INTO DBADMIN.SupportGroup (name)
VALUES
    ('2-я линия ИТ-Балхаш');
INSERT INTO DBADMIN.SupportGroup (name)
VALUES
    ('2-я линия ИТ-Восток');


-- Вставка данных в таблицу LayingMethods
INSERT INTO DBADMIN.LayingMethods (name)
VALUES
    ('Траншея (земля, грунт)');
INSERT INTO DBADMIN.LayingMethods (name)
VALUES
    ('Воздушный (крыши, столбы, опоры)');
INSERT INTO DBADMIN.LayingMethods (name)
VALUES
    ('Эстакада (Магистральная, технологическая)');
INSERT INTO DBADMIN.LayingMethods (name)
VALUES
    ('Телефонная канализация');
INSERT INTO DBADMIN.LayingMethods (name)
VALUES
    ('Внутри ЗиС (АБК, цеха)');
INSERT INTO DBADMIN.LayingMethods (name)
VALUES
    ('Подземная (шахты, рудники)');





-- Вставка данных в таблицу CableBrands
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКЛО-12G', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС ОКГ-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКЛО-П8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКЛ-П-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('ОКБ-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКЛ-П-SM-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКБ-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКТО-П-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКГ-П-SM-8 FF', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКГ-П-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('ОКСЛ-М2П-А8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('ОКЛ-П-SM-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКГО-П-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКГ-П-SM-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('ОКЛ-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('ОКЛО-8', 'ВОК 8');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКЛО-12', 'ВОК 12');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКТО-П-12-G', 'ВОК 12');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКЛ-SM-12FF', 'ВОК 12');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКТО-П-12', 'ВОК 12');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКЛ-П-12', 'ВОК 12');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКЛ-SM-12', 'ВОК 12');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('ADSS-12-65-2D', 'ВОК 12');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('ВОЛС ОКЛ-12', 'ВОК 12');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('ОКТО-12', 'ВОК 12');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКГ-П-4', 'ВОК 4');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('ОКЛ-4', 'ВОК 4');
INSERT INTO DBADMIN.CableBrands (name, cable_type)
VALUES
    ('КС-ОКЛО-4', 'ВОК 4');


INSERT INTO DBADMIN.OPTICAL_FIBER_LINE_TYPES (name) VALUES ('Распределительная линия');
INSERT INTO DBADMIN.OPTICAL_FIBER_LINE_TYPES (name) VALUES  ('Магистральная линия');
