INSERT INTO job.category(id, name) VALUES
(1, 'IT'),
(2, 'Дизайн'),
(3, 'Перевезення'),
(4, 'Туризм');
COMMIT;

INSERT INTO job.company(id, name,description) VALUES
(1, 'SoftByBodya','Boday company'),
(2, 'VeryBadCompany','We are bad boys');
COMMIT;

INSERT INTO job.account(id, email,linked_in,password,phone,role) VALUES
(1, 'SoftByBodya@gmail.com','link','Password1','+3542000','COMPANY'),
(2, 'VeryBadCompany@gmail.com','link','Password1','+3542000','COMPANY');
COMMIT;

INSERT INTO job.category_accounts(accounts_id,category_id) VALUES
(1,1),
(1,3),
(2,4);
COMMIT;

INSERT INTO job.vacancy(id, name,description,salary,visible,company_id) VALUES
(1,'Java-програміст','Опис ваканції один',11000,true,1),
(2,'Веб-дизайнер','Опис ваканції два',9000,true,1),
(3,'Перевізник','Опис ваканції три',12000,true,2),
(4,'Тур-агент','Опис ваканції 5',14000,true,1);
COMMIT;

INSERT INTO job.vacancy_categories(categories_id,vacancy_id) VALUES
(1,1),
(1,2),
(2,2),
(3,3),
(4,4);
COMMIT;