INSERT INTO job.category(id, name) VALUES
(1, 'IT'),
(2, 'Дизайн'),
(3, 'Перевезення'),
(4, 'Туризм');
COMMIT;

INSERT INTO job.company(id, name,description) VALUES
(1, 'SoftByBodya','Bodya company'),
(2, 'VeryBadCompany','We are bad boys');
COMMIT;

INSERT INTO job.user(id, name,second_name, description) VALUES
(3, 'Bohdan','Petrov','description'),
(4, 'Ivan','Ivanov','description');
COMMIT;

INSERT INTO job.account(id, email,linked_in,password,phone,role) VALUES
(1, 'SoftByBodya@gmail.com','link','{noop}Password1','+3542000','COMPANY'),
(2, 'VeryBadCompany@gmail.com','link','{noop}Password1','+332222','COMPANY'),
(3, 'BodyaBest@gmail.com','link','{noop}Password1','+355845','USER'),
(4, 'VeryBadWorker@gmail.com','link','{noop}Password1','+3556422','USER'),
(5, 'VeryBadAdmin@gmail.com','link','{noop}Password1','+3555552','ADMIN');
COMMIT;

INSERT INTO job.category_accounts(accounts_id,category_id) VALUES
(1,1),
(1,3),
(2,4);
COMMIT;

INSERT INTO job.vacancy(id, name,small_description,big_description,level,salary,visible,company_id) VALUES
(1,'Java-програміст','Малий опис ваканції один',
 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa sed elementum tempus egestas sed sed risus pretium quam. Eget arcu dictum varius duis at consectetur lorem. In nibh mauris cursus mattis molestie. Sed egestas egestas fringilla phasellus faucibus scelerisque. Suspendisse in est ante in nibh mauris. Adipiscing elit pellentesque habitant morbi tristique. Leo a diam sollicitudin tempor id eu nisl nunc. Turpis massa sed elementum tempus egestas sed sed risus pretium. Velit sed ullamcorper morbi tincidunt. Nec dui nunc mattis enim. Molestie nunc non blandit massa enim nec. Odio facilisis mauris sit amet massa vitae. Lacus sed viverra tellus in hac habitasse platea dictumst vestibulum.

Non nisi est sit amet facilisis magna etiam tempor. Nulla aliquet porttitor lacus luctus accumsan. Et egestas quis ipsum suspendisse ultrices gravida dictum. Aliquam nulla facilisi cras fermentum odio eu feugiat. In ante metus dictum at. Adipiscing elit duis tristique sollicitudin nibh. At urna condimentum mattis pellentesque id nibh tortor id aliquet. Nunc aliquet bibendum enim facilisis gravida. Volutpat est velit egestas dui. Ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget. Ultricies integer quis auctor elit sed vulputate mi sit. At imperdiet dui accumsan sit amet nulla facilisi morbi.

Risus ultricies tristique nulla aliquet enim. Ultricies tristique nulla aliquet enim. Quis commodo odio aenean sed adipiscing diam. Cum sociis natoque penatibus et magnis dis parturient montes. Duis ultricies lacus sed turpis tincidunt id. Turpis egestas sed tempus urna et pharetra. Vitae elementum curabitur vitae nunc sed velit. Sed euismod nisi porta lorem. Tempus quam pellentesque nec nam aliquam sem et. Hac habitasse platea dictumst quisque sagittis purus sit amet. Maecenas volutpat blandit aliquam etiam erat velit scelerisque in. Urna porttitor rhoncus dolor purus non. Diam ut venenatis tellus in metus. Quam id leo in vitae turpis massa. Adipiscing elit ut aliquam purus sit amet luctus. Libero nunc consequat interdum varius sit. Orci dapibus ultrices in iaculis. Id diam maecenas ultricies mi eget mauris. Vitae proin sagittis nisl rhoncus mattis.

Enim neque volutpat ac tincidunt vitae semper quis lectus nulla. Nunc vel risus commodo viverra maecenas accumsan lacus vel. Et netus et malesuada fames ac turpis egestas. Id diam maecenas ultricies mi eget mauris pharetra. Lobortis elementum nibh tellus molestie nunc non blandit massa. Faucibus interdum posuere lorem ipsum dolor sit. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Feugiat nisl pretium fusce id velit ut tortor pretium viverra. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Nisl purus in mollis nunc sed id semper risus. Elementum eu facilisis sed odio morbi quis commodo.',
 'JUNIOR',11000,true,1),
(2,'Веб-дизайнер','Малий опис ваканції два','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa sed elementum tempus egestas sed sed risus pretium quam. Eget arcu dictum varius duis at consectetur lorem. In nibh mauris cursus mattis molestie. Sed egestas egestas fringilla phasellus faucibus scelerisque. Suspendisse in est ante in nibh mauris. Adipiscing elit pellentesque habitant morbi tristique. Leo a diam sollicitudin tempor id eu nisl nunc. Turpis massa sed elementum tempus egestas sed sed risus pretium. Velit sed ullamcorper morbi tincidunt. Nec dui nunc mattis enim. Molestie nunc non blandit massa enim nec. Odio facilisis mauris sit amet massa vitae. Lacus sed viverra tellus in hac habitasse platea dictumst vestibulum.

Non nisi est sit amet facilisis magna etiam tempor. Nulla aliquet porttitor lacus luctus accumsan. Et egestas quis ipsum suspendisse ultrices gravida dictum. Aliquam nulla facilisi cras fermentum odio eu feugiat. In ante metus dictum at. Adipiscing elit duis tristique sollicitudin nibh. At urna condimentum mattis pellentesque id nibh tortor id aliquet. Nunc aliquet bibendum enim facilisis gravida. Volutpat est velit egestas dui. Ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget. Ultricies integer quis auctor elit sed vulputate mi sit. At imperdiet dui accumsan sit amet nulla facilisi morbi.

Risus ultricies tristique nulla aliquet enim. Ultricies tristique nulla aliquet enim. Quis commodo odio aenean sed adipiscing diam. Cum sociis natoque penatibus et magnis dis parturient montes. Duis ultricies lacus sed turpis tincidunt id. Turpis egestas sed tempus urna et pharetra. Vitae elementum curabitur vitae nunc sed velit. Sed euismod nisi porta lorem. Tempus quam pellentesque nec nam aliquam sem et. Hac habitasse platea dictumst quisque sagittis purus sit amet. Maecenas volutpat blandit aliquam etiam erat velit scelerisque in. Urna porttitor rhoncus dolor purus non. Diam ut venenatis tellus in metus. Quam id leo in vitae turpis massa. Adipiscing elit ut aliquam purus sit amet luctus. Libero nunc consequat interdum varius sit. Orci dapibus ultrices in iaculis. Id diam maecenas ultricies mi eget mauris. Vitae proin sagittis nisl rhoncus mattis.

Enim neque volutpat ac tincidunt vitae semper quis lectus nulla. Nunc vel risus commodo viverra maecenas accumsan lacus vel. Et netus et malesuada fames ac turpis egestas. Id diam maecenas ultricies mi eget mauris pharetra. Lobortis elementum nibh tellus molestie nunc non blandit massa. Faucibus interdum posuere lorem ipsum dolor sit. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Feugiat nisl pretium fusce id velit ut tortor pretium viverra. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Nisl purus in mollis nunc sed id semper risus. Elementum eu facilisis sed odio morbi quis commodo.','JUNIOR',9000,true,1),
(3,'Перевізник','Малий опис ваканції три','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa sed elementum tempus egestas sed sed risus pretium quam. Eget arcu dictum varius duis at consectetur lorem. In nibh mauris cursus mattis molestie. Sed egestas egestas fringilla phasellus faucibus scelerisque. Suspendisse in est ante in nibh mauris. Adipiscing elit pellentesque habitant morbi tristique. Leo a diam sollicitudin tempor id eu nisl nunc. Turpis massa sed elementum tempus egestas sed sed risus pretium. Velit sed ullamcorper morbi tincidunt. Nec dui nunc mattis enim. Molestie nunc non blandit massa enim nec. Odio facilisis mauris sit amet massa vitae. Lacus sed viverra tellus in hac habitasse platea dictumst vestibulum.

Non nisi est sit amet facilisis magna etiam tempor. Nulla aliquet porttitor lacus luctus accumsan. Et egestas quis ipsum suspendisse ultrices gravida dictum. Aliquam nulla facilisi cras fermentum odio eu feugiat. In ante metus dictum at. Adipiscing elit duis tristique sollicitudin nibh. At urna condimentum mattis pellentesque id nibh tortor id aliquet. Nunc aliquet bibendum enim facilisis gravida. Volutpat est velit egestas dui. Ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget. Ultricies integer quis auctor elit sed vulputate mi sit. At imperdiet dui accumsan sit amet nulla facilisi morbi.

Risus ultricies tristique nulla aliquet enim. Ultricies tristique nulla aliquet enim. Quis commodo odio aenean sed adipiscing diam. Cum sociis natoque penatibus et magnis dis parturient montes. Duis ultricies lacus sed turpis tincidunt id. Turpis egestas sed tempus urna et pharetra. Vitae elementum curabitur vitae nunc sed velit. Sed euismod nisi porta lorem. Tempus quam pellentesque nec nam aliquam sem et. Hac habitasse platea dictumst quisque sagittis purus sit amet. Maecenas volutpat blandit aliquam etiam erat velit scelerisque in. Urna porttitor rhoncus dolor purus non. Diam ut venenatis tellus in metus. Quam id leo in vitae turpis massa. Adipiscing elit ut aliquam purus sit amet luctus. Libero nunc consequat interdum varius sit. Orci dapibus ultrices in iaculis. Id diam maecenas ultricies mi eget mauris. Vitae proin sagittis nisl rhoncus mattis.

Enim neque volutpat ac tincidunt vitae semper quis lectus nulla. Nunc vel risus commodo viverra maecenas accumsan lacus vel. Et netus et malesuada fames ac turpis egestas. Id diam maecenas ultricies mi eget mauris pharetra. Lobortis elementum nibh tellus molestie nunc non blandit massa. Faucibus interdum posuere lorem ipsum dolor sit. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Feugiat nisl pretium fusce id velit ut tortor pretium viverra. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Nisl purus in mollis nunc sed id semper risus. Elementum eu facilisis sed odio morbi quis commodo.','JUNIOR',12000,true,2),
(4,'Тур-агент','Малий опис ваканції 5','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa sed elementum tempus egestas sed sed risus pretium quam. Eget arcu dictum varius duis at consectetur lorem. In nibh mauris cursus mattis molestie. Sed egestas egestas fringilla phasellus faucibus scelerisque. Suspendisse in est ante in nibh mauris. Adipiscing elit pellentesque habitant morbi tristique. Leo a diam sollicitudin tempor id eu nisl nunc. Turpis massa sed elementum tempus egestas sed sed risus pretium. Velit sed ullamcorper morbi tincidunt. Nec dui nunc mattis enim. Molestie nunc non blandit massa enim nec. Odio facilisis mauris sit amet massa vitae. Lacus sed viverra tellus in hac habitasse platea dictumst vestibulum.

Non nisi est sit amet facilisis magna etiam tempor. Nulla aliquet porttitor lacus luctus accumsan. Et egestas quis ipsum suspendisse ultrices gravida dictum. Aliquam nulla facilisi cras fermentum odio eu feugiat. In ante metus dictum at. Adipiscing elit duis tristique sollicitudin nibh. At urna condimentum mattis pellentesque id nibh tortor id aliquet. Nunc aliquet bibendum enim facilisis gravida. Volutpat est velit egestas dui. Ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget. Ultricies integer quis auctor elit sed vulputate mi sit. At imperdiet dui accumsan sit amet nulla facilisi morbi.

Risus ultricies tristique nulla aliquet enim. Ultricies tristique nulla aliquet enim. Quis commodo odio aenean sed adipiscing diam. Cum sociis natoque penatibus et magnis dis parturient montes. Duis ultricies lacus sed turpis tincidunt id. Turpis egestas sed tempus urna et pharetra. Vitae elementum curabitur vitae nunc sed velit. Sed euismod nisi porta lorem. Tempus quam pellentesque nec nam aliquam sem et. Hac habitasse platea dictumst quisque sagittis purus sit amet. Maecenas volutpat blandit aliquam etiam erat velit scelerisque in. Urna porttitor rhoncus dolor purus non. Diam ut venenatis tellus in metus. Quam id leo in vitae turpis massa. Adipiscing elit ut aliquam purus sit amet luctus. Libero nunc consequat interdum varius sit. Orci dapibus ultrices in iaculis. Id diam maecenas ultricies mi eget mauris. Vitae proin sagittis nisl rhoncus mattis.

Enim neque volutpat ac tincidunt vitae semper quis lectus nulla. Nunc vel risus commodo viverra maecenas accumsan lacus vel. Et netus et malesuada fames ac turpis egestas. Id diam maecenas ultricies mi eget mauris pharetra. Lobortis elementum nibh tellus molestie nunc non blandit massa. Faucibus interdum posuere lorem ipsum dolor sit. Urna nec tincidunt praesent semper feugiat nibh sed pulvinar. Feugiat nisl pretium fusce id velit ut tortor pretium viverra. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Nisl purus in mollis nunc sed id semper risus. Elementum eu facilisis sed odio morbi quis commodo.','JUNIOR',14000,true,1);
COMMIT;

INSERT INTO job.vacancy_categories(categories_id,vacancy_id) VALUES
(1,1),
(1,2),
(2,2),
(3,3),
(4,4);
COMMIT;