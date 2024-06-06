INSERT INTO offers (id, name, book_price, description) values (1, 'Аренда беседки', 500, 'Отличное место, чтобы отдохнуть и обсудить прошедшие игры. 2 широких стола и длинные лавочки прекрасно дополнят этот день') ;
INSERT INTO offers (id, name, book_price, description) values (2, 'Прокат оборудования', 1200, 'Есть все, что нужно: аммуниция, маркер, перчатки и 200 шаров в комплекте') ;
INSERT INTO offers (id, name, book_price, description) values (3, 'Дополнительные шары', 1000, 'Цена указана за 500 шариков') ;
INSERT INTO offers (id, name, book_price, description) values (4, 'Разгрузка и набор туб', 200, 'Почувствуйте себя Рэмбо') ;
INSERT INTO offers (id, name, book_price, description) values (5, 'Прицел', 100, 'Бесполезно, но стильно') ;
INSERT INTO offers (id, name, book_price, description) values (6, 'Дымовая шашка', 240, 'Отвлеките внимани противника сплошным туманом') ;
INSERT INTO offers (id, name, book_price, description) values (7, 'Граната имитационная', 300, 'Соперник скрылся за укрытием? Не беда, если под рукой есть это чудо') ;
INSERT INTO offers (id, name, book_price, description) values (8, 'Аренда мангала', 400, 'Угоститесь прекрасным шашлыком не отходя от игрового поля') ;
INSERT INTO offers (id, name, book_price, description) values (9, 'Приспособления для мангала', 300, 'Станьте шеф-поваром с этим набором');
INSERT INTO offers (id, name, book_price, description) values (10, 'Бронежилет', 100, 'Женщинам и детям - бесплатно!');
INSERT INTO offers (id, name, book_price, description) values (11, 'Непотеющая маска', 400, 'Дышите, сколько влезет и не переживайте о том, что маска начнет потеть') ;
INSERT INTO offers (id, name, book_price, description) values (12, 'Баллон повышенного давления', 200, 'Стреляйте на огромные расстояния благодаря этому приспособлению!') ;
-- ALTER TABLE user_roles ADD COLUMN id serial NOT NULL;
-- ALTER TABLE user_roles ADD CONSTRAINT prima_key PRIMARY KEY (id);

INSERT INTO roles (id, role) VALUES (0, 'ROLE_USER') ON CONFLICT DO NOTHING;
INSERT INTO roles (id, role) VALUES (1, 'ROLE_ADMIN') ON CONFLICT DO NOTHING;

INSERT INTO users (id, name, password, phone_number, sir_name, user_name, account_non_locked) VALUES (0, '-', '$2a$12$UxaX6oq8qWJoSA2qMX9LWeLT0dtaKiS7NcXXDnFFl1wxFNustGxIK', '-', '-', 'admin', true) ON CONFLICT DO NOTHING;
INSERT INTO user_roles(user_id, role_id) VALUES (0, 1) ON CONFLICT DO NOTHING;