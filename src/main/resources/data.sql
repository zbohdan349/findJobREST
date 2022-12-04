INSERT INTO category(id, name) VALUES
(1, 'IT'),
(2, 'Дизайн'),
(3, 'Перевезення'),
(4, 'Туризм');
COMMIT;
INSERT INTO account(id, email,linked_in,password,phone,role) VALUES
 (1, 'SoftByBodya@gmail.com','link','{noop}Password1','+3542000','COMPANY'),
 (2, 'VeryBadCompany@gmail.com','link','{noop}Password1','+332222','COMPANY'),
 (3, 'BodyaBest@gmail.com','link','{noop}Password1','+355845','USER'),
 (4, 'VeryBadWorker@gmail.com','link','{noop}Password1','+3556422','USER'),
 (5, 'VeryBadAdmin@gmail.com','link','{noop}Password1','+3555552','ADMIN');
COMMIT;

INSERT INTO company(id, name,description) VALUES
(1, 'SoftByBodya','Bodya company'),
(2, 'VeryBadCompany','We are bad boys');
COMMIT;

INSERT INTO client(id, name,second_name, description) VALUES
(3, 'Bohdan','Petrov','description'),
(4, 'Ivan','Ivanov','description');
COMMIT;



INSERT INTO category_accounts(account_id,category_id) VALUES
(1,1),
(1,3),
(2,4);
COMMIT;

INSERT INTO vacancy(id, name,small_description,big_description,level,salary,visible,company_id) VALUES
(1,'Java-програміст','Малий опис вакансії','Великий опис','JUNIOR',11000,true,1),
(2,'Веб-дизайнер','Малий опис вакансії','Великий опис','JUNIOR',9000,true,2),
(3,'Дизайнер','Малий опис вакансії','Великий опис','JUNIOR',9000,true,2),
(4,'Дизайнер','Малий опис вакансії','Великий опис','JUNIOR',9000,true,1),
(5,'Дизайнер','Малий опис вакансії','Великий опис','JUNIOR',19000,true,1);
COMMIT;

INSERT INTO category_vacancy(category_id,vacancy_id) VALUES
(1,1),
(1,2),
(2,2),
(3,3),
(4,4),
(4,5);
COMMIT;

INSERT INTO teamwork(id, status, client_id, vacancy_id) VALUES
(1, "STARTED",3,1),
(2,"REJECTED",3,2),
(3,"APPROVED",3,3),
(4,"FINISHED",3,4);
COMMIT;