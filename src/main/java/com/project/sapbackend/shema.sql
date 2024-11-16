-- Таблица для хранения ролей
CREATE TABLE roles (
                       role_id SERIAL PRIMARY KEY,
                       role_name VARCHAR(50) NOT NULL
);

-- Таблица для описания прав CRUD
CREATE TABLE crud_permissions (
                                  permission_id SERIAL PRIMARY KEY,
                                  permission_name VARCHAR(10) NOT NULL,
                                  description TEXT
);

-- Таблица для описания прав RACI
CREATE TABLE raci_permissions (
                                  permission_id SERIAL PRIMARY KEY,
                                  permission_name VARCHAR(10) NOT NULL,
                                  description TEXT
);

-- Таблица для привязки ролей к CRUD правам
CREATE TABLE role_crud_permissions (
                                       role_id INT REFERENCES roles(role_id),
                                       permission_id INT REFERENCES crud_permissions(permission_id),
                                       PRIMARY KEY (role_id, permission_id)
);

-- Таблица для привязки ролей к RACI правам
CREATE TABLE role_raci_permissions (
                                       role_id INT REFERENCES roles(role_id),
                                       permission_id INT REFERENCES raci_permissions(permission_id),
                                       PRIMARY KEY (role_id, permission_id)
);

-- Вставка ролей
INSERT INTO roles (role_name) VALUES
                                  ('Инженер'),
                                  ('Администратор'),
                                  ('Пользователь'),
                                  ('Аналитик');

-- Вставка CRUD прав
INSERT INTO crud_permissions (permission_name, description) VALUES
                                                                ('C', 'Create - доступ на создание объектов БД'),
                                                                ('R', 'Read - доступ на чтение контента приложения'),
                                                                ('U', 'Update - доступ на обновление объектов БД'),
                                                                ('D', 'Delete - доступ на удаление объектов БД');

-- Вставка RACI прав
INSERT INTO raci_permissions (permission_name, description) VALUES
                                                                ('R', 'Responsible - Ответственный за работу'),
                                                                ('A', 'Accountable - Ответственный за результат'),
                                                                ('C', 'Consulted - Консультирующий'),
                                                                ('I', 'Informed - Информируемый');

-- Привязка CRUD прав к ролям
INSERT INTO role_crud_permissions (role_id, permission_id) VALUES
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Инженер'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'C')),
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Инженер'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'R')),
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Инженер'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'U')),
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Инженер'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'D')),

                                                               ((SELECT role_id FROM roles WHERE role_name = 'Администратор'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'C')),
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Администратор'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'R')),
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Администратор'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'U')),
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Администратор'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'D')),

                                                               ((SELECT role_id FROM roles WHERE role_name = 'Пользователь'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'C')),
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Пользователь'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'R')),

                                                               ((SELECT role_id FROM roles WHERE role_name = 'Аналитик'), (SELECT permission_id FROM crud_permissions WHERE permission_name = 'R'));

-- Привязка RACI прав к ролям
INSERT INTO role_raci_permissions (role_id, permission_id) VALUES
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Инженер'), (SELECT permission_id FROM raci_permissions WHERE permission_name = 'R')),
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Инженер'), (SELECT permission_id FROM raci_permissions WHERE permission_name = 'A')),

                                                               ((SELECT role_id FROM roles WHERE role_name = 'Администратор'), (SELECT permission_id FROM raci_permissions WHERE permission_name = 'R')),
                                                               ((SELECT role_id FROM roles WHERE role_name = 'Администратор'), (SELECT permission_id FROM raci_permissions WHERE permission_name = 'A')),

                                                               ((SELECT role_id FROM roles WHERE role_name = 'Пользователь'), (SELECT permission_id FROM raci_permissions WHERE permission_name = 'I')),

                                                               ((SELECT role_id FROM roles WHERE role_name = 'Аналитик'), (SELECT permission_id FROM raci_permissions WHERE permission_name = 'I'));


CREATE TABLE IT_Service_Catalog (
                                    service_id SERIAL PRIMARY KEY,  -- SERIAL type for auto-incrementing IDs
                                    service_name VARCHAR(255) NOT NULL  -- Service name column
);

CREATE TABLE Request_Types (
                               type_id SERIAL PRIMARY KEY,  -- SERIAL type for auto-incrementing IDs
                               service_id INT REFERENCES IT_Service_Catalog(service_id) ON DELETE CASCADE,  -- Foreign key to IT_Service_Catalog
                               type_name VARCHAR(255) NOT NULL  -- Type name column
);


-- Insert data into IT_Service_Catalog
INSERT INTO IT_Service_Catalog (service_name)
VALUES
    ('Поддержка волоконно-оптических линий связи');

-- Insert data into Request_Types linked to the appropriate service
INSERT INTO Request_Types (service_id, type_name)
VALUES
    (1, 'Восстановление ВОЛС'),
    (1, 'Ремонт оборудования ВОЛС'),
    (1, 'Решение инцидентов в работе ВОЛС');

-- Таблица для местоположений
CREATE TABLE Locations (
                           location_id SERIAL PRIMARY KEY,  -- Уникальный идентификатор местоположения
                           address VARCHAR(255) NOT NULL,   -- Адрес местоположения
                           region VARCHAR(100) NOT NULL     -- Регион местоположения
);

-- Вставка данных в таблицу Locations с указанием id
INSERT INTO Locations (location_id, address, region)
VALUES
    (1, 'в 30 км к западу от г. Жезказган', 'Улытауская область'),
    (2, 'Жезказганский регион', 'Улытауская область'),
    (4, 'Жанааркинский район, в 130 км к юго-востоку от г. Жезказган', 'Карагандинская область'),
    (6, 'промзона в 30-40км от г.Сатпаева', 'Улытауская область'),
    (8, 'промзона г. Сатпаев', 'Улытауская область'),
    (10, 'в 10 км севернее г. Темиртау', 'Карагандинская область'),
    (11, 'рудник "Абыз"', 'Карагандинская область'),
    (12, 'ВКО, Аягузский район', 'Восточно-Казахстанская область'),
    (13, 'г. Балхаш', 'Карагандинская область'),
    (14, 'Жамбылская область, г. Шу', 'Жамбылская область'),
    (15, '15км от г. Балхаш, микрорайон Коунрад', 'Карагандинская область'),
    (16, 'Каркаралинский район, пос. Карагайлы', 'Карагандинская область');

INSERT INTO Locations (location_id, address, region)
VALUES
    (3, 'Данные не были предоставлены', 'Данные не были предоставлены'),
    (5, 'Данные не были предоставлены', 'Данные не были предоставлены'),
    (7, 'Данные не были предоставлены', 'Данные не были предоставлены'),
    (9, 'Данные не были предоставлены', 'Данные не были предоставлены');
-- Таблица для административных объектов
CREATE TABLE AdministrativeObjects (
                                       object_id SERIAL PRIMARY KEY,    -- Уникальный идентификатор объекта
                                       name VARCHAR(255) NOT NULL,      -- Наименование объекта
                                       location_id INT,                 -- Ссылка на идентификатор местоположения из таблицы Locations
                                       FOREIGN KEY (location_id) REFERENCES Locations(location_id)  -- Внешний ключ на таблицу Locations
);


-- Вставка данных в таблицу AdministrativeObjects
INSERT INTO AdministrativeObjects (name, location_id)
VALUES
    ('Северо-Жезказганский рудник (СЖР)', 3),
    ('Рудник Кусмурын-Акбастау', 12),
    ('Рудник Конырат', 15),
    ('Карагайлинская ОФ (КОФ)', 16),
    ('Нурказганская ОФ (НОФ)', 10),
    ('ЖОФ №3', 8),
    ('Рудник Абыз', 11),
    ('Рудник Западный', 5),
    ('Балхашская ОФ (БОФ)', 13),
    ('Восточно-Жезказганский рудник (ВЖР)', 2),
    ('Рудник Шатыркуль', 14),
    ('Рудник Нурказган', 10),
    ('Южно-Жезказганский рудник (ЮЖР)', 1),
    ('ЖОФ №1, №2', 7),
    ('Рудник Саяк', 13),
    ('Рудник Жомарт', 4),
    ('Жиландинский рудник', 6);

-- Таблица для производственных объектов
CREATE TABLE ProductionObjects (
                                   production_object_id SERIAL PRIMARY KEY, -- Уникальный идентификатор производственного объекта
                                   name VARCHAR(255) NOT NULL,              -- Наименование производственного объекта
                                   admin_object_id INT,                     -- Ссылка на идентификатор административного объекта
                                   FOREIGN KEY (admin_object_id) REFERENCES AdministrativeObjects(object_id) -- Внешний ключ на AdministrativeObjects
);


-- Вставка данных в таблицу ProductionObjects
INSERT INTO ProductionObjects (name, admin_object_id)
VALUES
    ('Шахта №57', 2),
    ('Шахта Анненская', 2),
    ('Шахта №65', 1),
    ('Шахта Саяк - 1', 13),
    ('Шахта Шатыркуль', 14),
    ('Шахта №55', 2),
    ('Шахта №73/75', 5),
    ('Шахта №67', 5),
    ('Шахта Абыз', 11),
    ('Шахта Нурказган', 10),
    ('Шахта Жомарт', 4),
    ('Шахта Жыланды', 6),
    ('Шахта Кусмурын-Акбастау', 12);

-- Таблица для Горизонтов
CREATE TABLE Horizons (
                          horizon_id SERIAL PRIMARY KEY,      -- Уникальный идентификатор горизонта
                          name VARCHAR(255) NOT NULL,         -- Наименование горизонта
                          production_object_id INT,           -- Ссылка на идентификатор производственного объекта
                          FOREIGN KEY (production_object_id) REFERENCES ProductionObjects(production_object_id) -- Внешний ключ на ProductionObjects
);


-- Вставка данных в таблицу Horizons
INSERT INTO Horizons (name, production_object_id)
VALUES
    ('Горизонт "+220м"', 1),
    ('Горизонт "+180 м"', 1),
    ('Горизонт "+90м"', 1),
    ('Дозатор Горизонт "-20м"', 1),
    ('Зумпф Горизонт "-80м"', 1),
    ('Горизонт +170', 2),
    ('Горизонт +90', 2),
    ('Горизонт +75', 2),
    ('Горизонт -50', 2),
    ('Горизонт -90', 2),
    ('Горизонт -230', 2),
    ('Горизонт -275', 2),
    ('Горизонт +140', 3),
    ('Горизонт 235 шахта 45', 3),
    ('Горизонт 305 шахта 45', 3),
    ('Горизонт 305, 235 шахта 45', 3),
    ('Горизонт 100', 3),
    ('Горизонт 140', 3),
    ('Горизонт 30', 3),
    ('Горизонт 206', 4),
    ('Горизонт 490', 4),
    ('Горизонт 491', 4),
    ('Горизонт 187', 4),
    ('Горизонт 160', 4),
    ('Транспортный уклон горизонт №4 горизонт 314', 4),
    ('Транспортный уклон горизонт №3 горизонт 345', 4),
    ('Горизонт 125', 4),
    ('Горизонт 507', 4),
    ('Горизонт 520', 4),
    ('Горизонт 460', 4),
    ('Горизонт 470', 4),
    ('Горизонт 485', 4),
    ('Сопряжение на портал 355 горизонт 310', 4),
    ('Горизонт 240', 4),
    ('Транспортный уклон горизонт №2 горизонт 394', 4),
    ('Портал горизонт 450', 4),
    ('Транспортный уклон горизонт №1 428', 4),
    ('Горизонт 447', 4),
    ('Транспортный уклон №3 гор. 850', 5),
    ('Портал №2 Штрек 2 горизонт 840', 5),
    ('Съезд на горизонт 780', 5),
    ('Горизонт 760', 5),
    ('Штрек 3 горизонт 800', 5),
    ('Штрек 3 горизонт 740', 5),
    ('Штрек 3 горизонт 720', 5),
    ('Штрек 3 горизонт 680', 5),
    ('Штрек 3 горизонт 620', 5),
    ('Штрек 3 горизонт 560', 5),
    ('Штрек 3 горизонт 520', 5),
    ('Штрек 3 горизонт 500', 5),
    ('Штрек 3 горизонт 440', 5),
    ('Штрек 3 горизонт 380', 5),
    ('Транспортный уклон №1 гор. 780', 5),
    ('Горизонт 625', 5),
    ('Горизонт 640', 5),
    ('Горизонт 540', 5),
    ('Горизонт 680', 5),
    ('Портал №6 Съезд на горизонт 800', 5),
    ('Портал №6 Съезд на горизонт 840', 5),
    ('Портал №6 Съезд на горизонт 860', 5),
    ('Портал №3 контейнер гор. 905', 5),
    ('Горизонт 265 м', 6),
    ('Горизонт 220 м', 6),
    ('Горизонт 180 м', 6),
    ('Горизонт 18 м', 6),
    ('Горизонт 300 м Западный портал', 6),
    ('Поверхность', 7),
    ('Нулевая отметка', 7),
    ('Ствол шахты', 7),
    ('Горизонт -20', 7),
    ('Горизонт -90', 7),
    ('Горизонт -128', 7),
    ('Горизонт -205', 7),
    ('Горизонт -257', 7),
    ('Горизонт -60', 7),
    ('Горизонт -60', 8),
    ('Горизонт +60', 8),
    ('Горизонт +30', 8),
    ('Горизонт -20', 8),
    ('Горизонт -140', 8),
    ('Горизонт -125', 8),
    ('Горизонт -240', 8),
    ('Горизонт -175', 8),
    ('Горизонт +20', 8),
    ('Горизонт +100', 8),
    ('Горизонт +640', 9),
    ('Горизонт +590', 9),
    ('Горизонт +490', 9),
    ('Горизонт +457', 9),
    ('Горизонт +406', 9),
    ('Горизонт +390', 9),
    ('Горизонт +440', 9),
    ('Портал', 10),
    ('Конвейерный уклон 1', 10),
    ('Транспортный уклон №1', 10),
    ('Горизонт +300', 10),
    ('Горизонт +280', 10),
    ('Горизонт +320', 10),
    ('Транспортный уклон №2', 10),
    ('Горизонт +275', 10),
    ('Горизонт +245', 10),
    ('Горизонт -190', 11),
    ('Устье портала', 12),
    ('Горизонт 300', 12),
    ('Горизонт 200', 12),
    ('Горизонт 150', 12),
    ('Горизонт 0', 12);

CREATE TABLE optical_fiber_line_types (
                                          id SERIAL PRIMARY KEY,
                                          name VARCHAR(255) NOT NULL
);

INSERT INTO optical_fiber_line_types (name) VALUES
                                                ('Распределительная линия'),
                                                ('Магистральная линия');


CREATE TABLE optical_fiber_lines (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     administrative_object_id INT,
                                     FOREIGN KEY (administrative_object_id) REFERENCES AdministrativeObjects(object_id)
);

INSERT INTO optical_fiber_lines (name, administrative_object_id) VALUES
                                                                     ('Волоконно-оптическая линия связи от TORO сервис до ГСМ', 13),
                                                                     ('Волоконно-оптическая линия связи от САТ сервис до TORO сервис', 13),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до КМС 1', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта 55 от ГСМ до участка № 54', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до участка № 55', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до склада ВМ', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта 55 от участка 55 до ГСМ', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта Анненская гор -50 м от АТС через отм -5 м до склада ВМ', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения, через отм 16 до 0 отметки на гора по стволу на руддвор горизонт 220 м шахта 57', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта Анненская гор -90 м от АТС через отм -5 м до гор -50м, КМС 2 (Торо Сервис)', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до гаража связи', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта Анненская гор -50 м от АТС через отм -5 м до ГСМ', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта Анненская гор -90 м от АТС через отм -5 м до КМС 1 (Сат Сервис)', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта Анненская от АТС через отм -5 м, по стволу до гор -90 м на руддвор, через руддвор до гаража связи', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до руддвора гор 265 м', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР от руддвор горизонт 220м по стволу до гор 90 м ЦРП шахта 57', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения до ВМ склад горизонт 220м шахта 57', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР от ВМ склад горизонт 220м до гаража связи горизонт 220м шахта 57', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения до КМС1 (Атлас Копко) горизонт 220 шахта 57', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения до КМС 2 (Кат Сервис) горизонт 180м шахта 57', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения до материальный склад горизонт 180 шахта 57', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР от АТС серверного помещения до ГСМ на горизонт 180м шахта 57', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта 55 от руддвора гор 265 м по стволу через руддвор гор 180 м до ЦРП', 10),
                                                                     ('Волоконно-оптическая линия связи ВЖР шахта 55 с АТС отм 40 м через 0 отм по стволу до КМС 2', 10),
                                                                     ('Волоконно-оптическая линия связи от AБК (АТС) р.Жомарт до Грузовой р.Жомарт', 16),
                                                                     ('Волоконно-оптическая линия связи от Грузовой ствол до Драбилка №4 р.Жомарт', 16);

-- Создание таблицы Employees
CREATE TABLE Employees (
                           employee_id SERIAL PRIMARY KEY,      -- Уникальный идентификатор сотрудника
                           full_name VARCHAR(255) NOT NULL,    -- ФИО сотрудника
                           department VARCHAR(255) NOT NULL,    -- Подразделение
                           position VARCHAR(255) NOT NULL       -- Позиция
);

-- Вставка данных в таблицу Employees
INSERT INTO Employees (full_name, department, position)
VALUES
    ('Сидоров Алексей Петрович', 'Головной центр телекоммуникаций', 'Мастер участка (сменный)'),
    ('Кузнецова Мария Ивановна', 'Головной центр телекоммуникаций', 'Мастер участка (сменный)'),
    ('Смирнов Дмитрий Сергеевич', 'Головной центр телекоммуникаций', 'Мастер участка (сменный)'),
    ('Лебедева Анна Викторовна', 'Головной центр телекоммуникаций', 'Мастер участка'),
    ('Федоров Сергей Александрович', 'Головной центр телекоммуникаций', 'Мастер участка (сменный)');


-- Создание таблицы IncidentCauses
CREATE TABLE IncidentCauses (
                                cause_id SERIAL PRIMARY KEY,        -- Уникальный идентификатор причины
                                name VARCHAR(255) NOT NULL          -- Наименование причины
);

-- Вставка данных в таблицу IncidentCauses
INSERT INTO IncidentCauses (name)
VALUES
    ('Хищение/кража'),
    ('Повреждение'),
    ('Отсутствие электропитания'),
    ('Обрыв линии'),
    ('Обрушение/отслоение горной массы'),
    ('Другое');

-- Создание таблицы AcceptedMeasures
CREATE TABLE AcceptedMeasures (
                                  measure_id SERIAL PRIMARY KEY,      -- Уникальный идентификатор меры
                                  name VARCHAR(255) NOT NULL          -- Наименование меры
);

-- Вставка данных в таблицу AcceptedMeasures
INSERT INTO AcceptedMeasures (name)
VALUES
    ('Восстановление обрыва'),
    ('Подбурка кабеля'),
    ('Прокладка кабеля на поверхности'),
    ('Перевешивание кабеля на другой борт'),
    ('Замена кабеля'),
    ('Спайка/распайка кабеля'),
    ('Другое');


-- Создание таблицы RequestExtensionCauses
CREATE TABLE RequestExtensionCauses (
                                        cause_id SERIAL PRIMARY KEY,        -- Уникальный идентификатор причины
                                        name VARCHAR(255) NOT NULL          -- Наименование причины
);

-- Вставка данных в таблицу RequestExtensionCauses
INSERT INTO RequestExtensionCauses (name)
VALUES
    ('Перенаправление запроса'),
    ('Отсутствие электропитания'),
    ('Отсутствие ТМЦ'),
    ('Необходимость создания безопасных условий');

-- Создание таблицы IncidentStatus
CREATE TABLE IncidentStatus (
                                status_id SERIAL PRIMARY KEY,      -- Уникальный идентификатор статуса
                                name VARCHAR(255) NOT NULL,        -- Наименование статуса
                                note VARCHAR(255)                  -- Примечание (может быть NULL)
);

-- Вставка данных в таблицу IncidentStatus
INSERT INTO IncidentStatus (name, note)
VALUES
    ('Решен', NULL),
    ('Отклонен', 'Подробная информация отклонения запроса описывается в поле "Решение"');

-- Создание таблицы RequestStatus
CREATE TABLE RequestStatus (
                               status_id SERIAL PRIMARY KEY,      -- Уникальный идентификатор статуса
                               name VARCHAR(255) NOT NULL         -- Наименование статуса
);

-- Вставка данных в таблицу RequestStatus
INSERT INTO RequestStatus (name)
VALUES
    ('Зарегистрирован'),
    ('Назначен'),
    ('В работе'),
    ('Закрыт');

-- Создание таблицы SupportGroup
CREATE TABLE SupportGroup (
                              group_id SERIAL PRIMARY KEY,       -- Уникальный идентификатор группы
                              name VARCHAR(255) NOT NULL         -- Наименование группы поддержки
);

-- Вставка данных в таблицу SupportGroup
INSERT INTO SupportGroup (name)
VALUES
    ('1-я линия ИТ-Service Desk'),
    ('2-я линия ИТ-Жезказган'),
    ('2-я линия ИТ-Балхаш'),
    ('2-я линия ИТ-Восток');

-- Создание таблицы ReferenceList
CREATE TABLE ReferenceList (
                               reference_id SERIAL PRIMARY KEY,    -- Уникальный идентификатор справочника
                               name VARCHAR(255) NOT NULL          -- Наименование справочника
);

-- Вставка данных в таблицу ReferenceList
INSERT INTO ReferenceList (name)
VALUES
    ('Местоположение'),
    ('Административный объект'),
    ('Производственный объект'),
    ('Горизонты'),
    ('Тип линии ВОЛС'),
    ('Линии ВОЛС'),
    ('Сотрудники'),
    ('Причины инцидентов ВОЛС'),
    ('Принятые меры'),
    ('Причины продления запросов'),
    ('Каталог ИТ-услуг'),
    ('Статус инцидента'),
    ('Статус запроса'),
    ('Группы поддержки');

-- Создание таблицы LayingMethods
CREATE TABLE LayingMethods (
                               method_id SERIAL PRIMARY KEY,    -- Уникальный идентификатор способа прокладки
                               name VARCHAR(255) NOT NULL       -- Наименование способа прокладки
);

-- Вставка данных в таблицу LayingMethods
INSERT INTO LayingMethods (name)
VALUES
    ('Траншея (земля, грунт)'),
    ('Воздушный (крыши, столбы, опоры)'),
    ('Эстакада (Магистральная, технологическая)'),
    ('Телефонная канализация'),
    ('Внутри ЗиС (АБК, цеха)'),
    ('Подземная (шахты, рудники)');

-- Создание таблицы CableBrands
CREATE TABLE CableBrands (
                             cable_id SERIAL PRIMARY KEY,          -- Уникальный идентификатор марки кабеля
                             name VARCHAR(255) NOT NULL,           -- Наименование марки кабеля
                             cable_type VARCHAR(50) NOT NULL       -- Тип кабеля (справочник ИТ-активов)
);

-- Вставка данных в таблицу CableBrands
INSERT INTO CableBrands (name, cable_type)
VALUES
    ('КС-ОКЛО-12G', 'ВОК 8'),
    ('КС ОКГ-8', 'ВОК 8'),
    ('КС-ОКЛО-П8', 'ВОК 8'),
    ('КС-ОКЛ-П-8', 'ВОК 8'),
    ('ОКБ-8', 'ВОК 8'),
    ('КС-ОКЛ-П-SM-8', 'ВОК 8'),
    ('КС-ОКБ-8', 'ВОК 8'),
    ('КС-ОКТО-П-8', 'ВОК 8'),
    ('КС-ОКГ-П-SM-8 FF', 'ВОК 8'),
    ('КС-ОКГ-П-8', 'ВОК 8'),
    ('ОКСЛ-М2П-А8', 'ВОК 8'),
    ('ОКЛ-П-SM-8', 'ВОК 8'),
    ('КС-ОКГО-П-8', 'ВОК 8'),
    ('КС-ОКГ-П-SM-8', 'ВОК 8'),
    ('ОКЛ-8', 'ВОК 8'),
    ('ОКЛО-8', 'ВОК 8'),
    ('КС-ОКЛО-12', 'ВОК 12'),
    ('КС-ОКТО-П-12-G', 'ВОК 12'),
    ('КС-ОКЛ-SM-12FF', 'ВОК 12'),
    ('КС-ОКТО-П-12', 'ВОК 12'),
    ('КС-ОКЛ-П-12', 'ВОК 12'),
    ('КС-ОКЛ-SM-12', 'ВОК 12'),
    ('ADSS-12-65-2D', 'ВОК 12'),
    ('ВОЛС ОКЛ-12', 'ВОК 12'),
    ('ОКТО-12', 'ВОК 12'),
    ('КС-ОКГ-П-4', 'ВОК 4'),
    ('ОКЛ-4', 'ВОК 4'),
    ('КС-ОКЛО-4', 'ВОК 4');

CREATE TABLE IT_Assets (
                           id SERIAL PRIMARY KEY,
                           category VARCHAR(255),
                           subcategory_ru VARCHAR(255),
                           subcategory_en VARCHAR(255),
                           asset_group_name_ru VARCHAR(255),
                           asset_group_name_en VARCHAR(255),
                           asset_subgroup_name_ru VARCHAR(255),
                           asset_subgroup_name_en VARCHAR(255),
                           asset_type_name_ru VARCHAR(255),
                           asset_type_name_en VARCHAR(255),
                           asset_brand_name_ru VARCHAR(255),
                           asset_brand_name_en VARCHAR(255),
                           spare_part_name_ru VARCHAR(255),
                           spare_part_name_en VARCHAR(255),
                           usage TEXT
);

INSERT INTO IT_Assets (category, subcategory_ru, subcategory_en, asset_group_name_ru, asset_group_name_en, asset_subgroup_name_ru, asset_subgroup_name_en, asset_type_name_ru, asset_type_name_en, asset_brand_name_ru, asset_brand_name_en, spare_part_name_ru, spare_part_name_en, usage)
VALUES
    ('Аппаратные ИТ-активы', 'Кабельная продукция', 'Cable products', 'Кабели связи', 'Communication cables', 'Медные кабели', 'Copper cables', 'Двухжильные', 'Two-core', 'ПКСВ 2х0,5', 'PVC 2х0,5', '-', '-', 'телефония, охранно-пожарная сигнализация, промышленная громкоговорящая связь, система контроля управления доступом'),
    ('Аппаратные ИТ-активы', 'Кабельная продукция', 'Cable products', 'Кабели связи', 'Communication cables', 'Медные кабели', 'Copper cables', 'Двухжильные', 'Two-core', 'П-274', 'wire-274', '-', '-', 'телефония, охранно-пожарная сигнализация, промышленная громкоговорящая связь'),
    ('Аппаратные ИТ-активы', 'Кабельная продукция', 'Cable products', 'Кабели связи', 'Communication cables', 'Медные кабели', 'Copper cables', 'Четырехжильные', 'Four-core', 'КСПВ 4х0,5', 'CSC 4х0,5', '-', '-', 'телефония, охранно-пожарная сигнализация, система контроля управления доступом'),
    ('Аппаратные ИТ-активы', 'Кабельная продукция', 'Cable products', 'Кабели связи', 'Communication cables', 'Медные кабели', 'Copper cables', 'Многожильные', 'Multi-core', 'ТППэП 100х2', 'FR-LSZHC 100х2', '-', '-', 'телефония, охранно-пожарная сигнализация'),
    ('Аппаратные ИТ-активы', 'Кабельная продукция', 'Cable products', 'Кабели связи', 'Communication cables', 'Медные кабели', 'Copper cables', 'Многожильные', 'Multi-core', 'ТППэП 50х2', 'FR-LSZHC 50х2', '-', '-', 'телефония, охранно-пожарная сигнализация'),
    ('Аппаратные ИТ-активы', 'Кабельная продукция', 'Cable products', 'Кабели связи', 'Communication cables', 'Медные кабели', 'Copper cables', 'Многожильные', 'Multi-core', 'ТППэП 30х2', 'FR-LSZHC 30х2', '-', '-', 'телефония, охранно-пожарная сигнализация'),
    ('Аппаратные ИТ-активы', 'Кабельная продукция', 'Cable products', 'Кабели связи', 'Communication cables', 'Медные кабели', 'Copper cables', 'Многожильные', 'Multi-core', 'ТППэП 20х2', 'FR-LSZHC 20х2', '-', '-', 'телефония, охранно-пожарная сигнализация'),
    ('Аппаратные ИТ-активы', 'Кабельная продукция', 'Cable products', 'Кабели связи', 'Communication cables', 'Медные кабели', 'Copper cables', 'Многожильные', 'Multi-core', 'ТППэП 10х2', 'FR-LSZHC 10х2', '-', '-', 'телефония, охранно-пожарная сигнализация');

INSERT INTO IT_Assets (
    category,
    subcategory_ru,
    subcategory_en,
    asset_group_name_ru,
    asset_group_name_en,
    asset_subgroup_name_ru,
    asset_subgroup_name_en,
    asset_type_name_ru,
    asset_type_name_en,
    asset_brand_name_ru,
    asset_brand_name_en,
    spare_part_name_ru,
    spare_part_name_en,
    usage
) VALUES
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Патч-корды', 'Patch cords', 'Медные патч-корды', 'Copper patch cords', 'Cat.5e', 'Cat.5e', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Патч-корды', 'Patch cords', 'Медные патч-корды', 'Copper patch cords', 'Cat.6', 'Cat.6', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Патч-корды', 'Patch cords', 'Оптические патч-корды', 'Optical patch cords', 'Одномодовые', 'Singlemode', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Патч-корды', 'Patch cords', 'Оптические патч-корды', 'Optical patch cords', 'Многомодовые', 'Multimode', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Патч-панели', 'Patch panels', 'Медные patch panels', 'Copper patch panels', 'Cat.5e', 'Cat.5e', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Патч-панели', 'Patch panels', 'Медные patch panels', 'Copper patch panels', 'Cat.6', 'Cat.6', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Сетевые розетки', 'Network sockets', 'Однопортовые сетевые розетки', 'Single-port network sockets', 'Cat.5e', 'Cat.5e', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Сетевые розетки', 'Network sockets', 'Однопортовые сетевые розетки', 'Single-port network sockets', 'Cat.6', 'Cat.6', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Сетевые розетки', 'Network sockets', 'Двухпортовые сетевые розетки', 'Two-port network sockets', 'Cat.5e', 'Cat.5e', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Сетевые розетки', 'Network sockets', 'Двухпортовые сетевые розетки', 'Two-port network sockets', 'Cat.6', 'Cat.6', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Кабельные органайзеры', 'Cable organizers', 'Горизонтальные кабельные органайзеры', 'Horizontal cable organizers', 'Открытого типа', 'Open type', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Кабельные органайзеры', 'Cable organizers', 'Горизонтальные кабельные органайзеры', 'Horizontal cable organizers', 'Закрытого типа', 'Closed type', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Кабельные органайзеры', 'Cable organizers', 'Вертикальные органайзеры', 'Vertical cable organizers', 'Открытого типа', 'Open type', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Кабельные органайзеры', 'Cable organizers', 'Вертикальные органайзеры', 'Vertical cable organizers', 'Закрытого типа', 'Closed type', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Кроссы', 'Crosses', 'Оптические кроссы', 'Optical crosses', 'Стоечные', 'Rack-mounted', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Кроссы', 'Crosses', 'Оптические кроссы', 'Optical crosses', 'Не стоечные', 'Not rack-mounted', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Распределительные шкафы', 'Distribution Cabinet', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Распределительные коробки', 'Distribution Box', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'кросс', 'TK (Telephone Switchboard)', 'плинты', 'Telephone pedestal', '-', '-', '-', '-', '-', '-',  '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Вентиляторы', 'Fans', 'Вентиляторные панели', 'Fan panels', 'Потолочные', 'Ceiling', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Оптические муфты', 'FOC (Fiber Optic Connector)', 'Проходные', 'PT (Pass Through)', '-', '-', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Оптические муфты', 'FOC (Fiber Optic Connector)', 'Тупиковые', 'SFC (Stub Fiber Connector)', '-', '-', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Оптические шнуры', 'OC (Optical Cables)', 'Соединительные', 'OCC (Optical Connector Cables)', '-', '-', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Оптические шнуры', 'OC (Optical Cables)', 'Монтажные', 'MOC (Mounting Optical Cables)', '-', '-', '-', '-', '-', '-', '-'),
      ('Аппаратные ИТ-активы', 'Структурированные кабельные системы', 'Structured cabling systems', 'Оптические шнуры', 'OC (Optical Cables)', 'Переходные', 'TOC (Transition Optical Cables)', '-', '-', '-', '-', '-', '-', '-');
INSERT INTO IT_Assets (category,
                       subcategory_ru,
                       subcategory_en,
                       asset_group_name_ru,
                       asset_group_name_en,
                       asset_subgroup_name_ru,
                       asset_subgroup_name_en,
                       asset_type_name_ru,
                       asset_type_name_en,
                       asset_brand_name_ru,
                       asset_brand_name_en,
                       spare_part_name_ru,
                       spare_part_name_en,
                       usage) VALUES
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Коммутаторы', 'Switches', 'Управляемые коммутаторы', 'Managed switches', 'Программные', 'Software', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Коммутаторы', 'Switches', 'Управляемые коммутаторы', 'Managed switches', 'Аппаратные', 'Hardware', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Коммутаторы', 'Switches', 'Неуправляемые коммутаторы', 'Unmanaged switches', 'Аппаратные', 'Hardware', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Маршрутизаторы', 'Routers', 'Программные маршрутизаторы', 'Software routers', 'Ethernet-маршрутизаторы', 'Ethernet routers', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Маршрутизаторы', 'Routers', 'Программные маршрутизаторы', 'Software routers', 'LTE-маршрутизаторы', 'LTE routers', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Маршрутизаторы', 'Routers', 'Аппаратные маршрутизаторы', 'Hardware routers', 'Ethernet-маршрутизаторы', 'Ethernet routers', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Маршрутизаторы', 'Routers', 'Аппаратные маршрутизаторы', 'Hardware routers', 'LTE-маршрутизаторы', 'LTE routers', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Межсетевые экраны', 'Firewalls', 'Программные межсетевые экраны', 'Software firewalls', 'Межсетевой экран нового поколения (NGFW)', 'Next-Generation Firewall (NGFW)', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Межсетевые экраны', 'Firewalls', 'Аппаратные межсетевые экраны', 'Hardware firewalls', 'Межсетевой экран нового поколения (NGFW)', 'Next-Generation Firewall (NGFW)', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Беспроводные точки доступа', 'Wireless access points', 'WiFi точки доступа', 'WiFi access points', 'Внутренние', 'Indoor', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Беспроводные точки доступа', 'Wireless access points', 'WiFi точки доступа', 'WiFi access points', 'Наружные', 'Outdoor', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Беспроводные точки доступа', 'Wireless access points', 'WiFi радиомосты', 'WiFi radio bridges', 'Внутренние', 'Indoor', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Беспроводные точки доступа', 'Wireless access points', 'WiFi радиомосты', 'WiFi radio bridges', 'Наружные', 'Outdoor', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Беспроводные точки доступа', 'Wireless access points', 'Радиорелейная линия (РРЛ)', 'Radio relay line (RRL)', 'Прямой видимости', 'Line of sight', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Беспроводные точки доступа', 'Wireless access points', 'Радиорелейная линия (РРЛ)', 'Radio relay line (RRL)', 'Тропосферные', 'Tropospheric', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Средства управления', 'Control systems', 'Контроллеры беспроводных точек доступа', 'Wireless access point controllers', 'Программные', 'Software', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Средства управления', 'Control systems', 'Контроллеры беспроводных точек доступа', 'Wireless access point controllers', 'Аппаратные', 'Hardware', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Средства управления', 'Control systems', 'Системы мониторинга', 'Monitoring systems', 'Программные', 'Software', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Средства управления', 'Control systems', 'Системы мониторинга', 'Monitoring systems', 'Аппаратные', 'Hardware', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Каналообразующее оборудование', 'Channel-forming device', 'Медиаконвертеры', 'Mediaconverters', 'Одномодовые', 'Singlemode', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Каналообразующее оборудование', 'Channel-forming device', 'Медиаконвертеры', 'Mediaconverters', 'Многомодовые', 'Multimode', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Каналообразующее оборудование', 'Channel-forming device', 'Оптические модули', 'Optical modules', 'Одномодовые', 'Singlemode', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Каналообразующее оборудование', 'Channel-forming device', 'Оптические модули', 'Optical modules', 'Многомодовые', 'Multimode', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Каналообразующее оборудование', 'Channel-forming device', 'Модемы', 'Modems', 'SHDSL-коммутаторы', 'SHDSL switches', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Каналообразующее оборудование', 'Channel-forming device', 'Модемы', 'Modems', 'SHDSL-модемы', 'SHDSL modems', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Каналообразующее оборудование', 'Channel-forming device', 'Мультиплексоры', 'Multiplexers', 'Управляемые', 'Managed', '-', '-', '-', '-', '-'),
                                  ('Аппаратные ИТ-активы', 'Сетевое оборудование', 'Network device', 'Каналообразующее оборудование', 'Channel-forming device', 'Мультиплексоры', 'Multiplexers', 'Неуправляемые', 'Unmanaged', '-', '-', '-', '-', '-');


CREATE TABLE IncidentRequests (
                                  request_id SERIAL PRIMARY KEY,  -- Unique identifier for the request
                                  registration_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Date and time of request registration
                                  service_id INT REFERENCES IT_Service_Catalog(service_id) ON DELETE SET NULL,  -- Service selected from IT Service Catalog
                                  request_type_id INT REFERENCES Request_Types(type_id) ON DELETE SET NULL,  -- Request type, filtered by selected service
                                  initiator_name VARCHAR(255) NOT NULL,  -- Automatically assigned name of the authorized user
                                  incident_location_id INT REFERENCES Locations(location_id) ON DELETE SET NULL,  -- Location of the incident
                                  additional_info VARCHAR(255),  -- Additional information about the incident location (manual input)
                                  support_group_id INT REFERENCES SupportGroup(group_id) ON DELETE SET NULL,  -- Automatically assigned support group
                                  redirect_count INT DEFAULT 0,  -- Count of request redirects (automatically managed by the system)
                                  incident_description TEXT NOT NULL,  -- Brief description of the incident (manual input)
                                  admin_object_id INT REFERENCES AdministrativeObjects(object_id) ON DELETE SET NULL,  -- Administrative object selected
                                  production_object_id INT REFERENCES ProductionObjects(production_object_id) ON DELETE SET NULL,  -- Production object selected, filtered by admin object
                                  fiber_name_id INT REFERENCES optical_fiber_lines(id) ON DELETE SET NULL,  -- Fiber name selected, filtered by production object
                                  line_type_id INT REFERENCES optical_fiber_line_types(id) ON DELETE SET NULL,  -- Line type selected (auto/manual input)
                                  horizon_id INT REFERENCES Horizons(horizon_id) ON DELETE SET NULL,  -- Reference to the Horizons table
                                  fiber_brand_id INT REFERENCES CableBrands(cable_id) ON DELETE SET NULL,  -- Fiber brand (auto/manual input)
                                  total_fibers INT,  -- Total number of fibers (auto/manual input)
                                  cable_length FLOAT,  -- Cable length (auto/manual input)
                                  laying_method_id INT REFERENCES LayingMethods(method_id) ON DELETE SET NULL,  -- Laying method (auto/manual input)
                                  incident_photo BYTEA  -- Incident photo (file upload)
);

CREATE TABLE IncidentRequestCauses (
                                       request_id INT REFERENCES IncidentRequests(request_id) ON DELETE CASCADE,
                                       cause_id INT REFERENCES IncidentCauses(cause_id) ON DELETE CASCADE,
                                       PRIMARY KEY (request_id, cause_id)  -- Composite primary key
);

CREATE TABLE RequestProcessing (
                                   request_id SERIAL PRIMARY KEY,                                 -- Уникальный идентификатор запроса
                                   material_costs FLOAT,                                         -- Материальные затраты (кабель, м)
                                   solution TEXT,                                                -- Решение
                                   comment TEXT,                                                -- Комментарий
                                   incident_status_id INT REFERENCES IncidentStatus(status_id) ON DELETE SET NULL, -- Статус инцидента
                                   request_status_id INT REFERENCES RequestStatus(status_id) ON DELETE SET NULL, -- Статус запроса
                                   closing_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP         -- Дата и время закрытия запроса
);

-- Create the junction table for many-to-many relationship between RequestProcessing and AcceptedMeasures
CREATE TABLE RequestAcceptedMeasures (
                                         request_id INT REFERENCES RequestProcessing(request_id) ON DELETE CASCADE,  -- Ссылка на запрос
                                         measure_id INT REFERENCES AcceptedMeasures(measure_id) ON DELETE CASCADE,    -- Ссылка на принятую меру
                                         PRIMARY KEY (request_id, measure_id)  -- Composite primary key for many-to-many relationship
);

-- Create the junction table for many-to-many relationship between RequestProcessing and Employees
CREATE TABLE RequestExecutors (
                                  request_id INT REFERENCES RequestProcessing(request_id) ON DELETE CASCADE,  -- Ссылка на запрос
                                  employee_id INT REFERENCES Employees(employee_id) ON DELETE CASCADE,       -- Ссылка на исполнителя
                                  PRIMARY KEY (request_id, employee_id)  -- Composite primary key for many-to-many relationship
);

-- Create the junction table for many-to-many relationship between RequestProcessing and RequestExtensionCauses
CREATE TABLE RequestExtensionCausesJunction (
                                                request_id INT REFERENCES RequestProcessing(request_id) ON DELETE CASCADE,  -- Ссылка на запрос
                                                cause_id INT REFERENCES RequestExtensionCauses(cause_id) ON DELETE CASCADE,  -- Ссылка на причину продления
                                                PRIMARY KEY (request_id, cause_id)  -- Composite primary key for many-to-many relationship
);


CREATE TABLE incidents (
                           id SERIAL PRIMARY KEY,
                           registration_time TIMESTAMP NOT NULL,
                           service VARCHAR(255) NOT NULL,
                           request_type VARCHAR(255) NOT NULL,
                           initiator VARCHAR(255) NOT NULL,
                           location VARCHAR(255) NOT NULL,
                           floor_office VARCHAR(255),
                           support_group INT NOT NULL,
                           redirect_count INT NOT NULL,
                           short_description TEXT NOT NULL,
                           administrative_object VARCHAR(255) NOT NULL,
                           production_object VARCHAR(255) NOT NULL,
                           name_of_fiber_optic_line VARCHAR(255) NOT NULL,
                           line_type VARCHAR(255) NOT NULL,
                           horizontal VARCHAR(255) NOT NULL,
                           fiber_optic_cable_brand VARCHAR(255) NOT NULL,
                           total_number_of_cores INT NOT NULL,
                           cable_length_m DECIMAL(10, 2) NOT NULL,
                           cable_laying_method VARCHAR(255) NOT NULL,
                           incident_reason VARCHAR(255) NOT NULL,
                           incident_photo VARCHAR(255),
                           measures_taken VARCHAR(255),
                           material_costs_cable_m DECIMAL(10, 2),
                           request_executor VARCHAR(255) NOT NULL,
                           incident_status VARCHAR(255) NOT NULL,
                           decision VARCHAR(255),
                           reasons_for_request_extension VARCHAR(255),
                           request_status VARCHAR(255) NOT NULL,
                           closure_datetime TIMESTAMP
);
