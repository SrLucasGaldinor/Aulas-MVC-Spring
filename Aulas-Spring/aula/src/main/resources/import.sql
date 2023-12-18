insert into tb_contatos (id, nome, email, fone)values(10,'Lucas','lucas@gmail.com','(50)99999-9999');
insert into tb_contatos (id, nome, email, fone)values(20 ,'Nelo','nelo@gmail.com','(55)99999-9995');

insert into tb_locais (id, nome, rua, numero, bairro, cidade, uf, cep)values(10,'Bar do Zaga','Santo André','160','Itopava','Blumenau','SC','500');
insert into tb_locais (id, nome, rua, numero, bairro, cidade, uf, cep)values(20,'Bar do Zé','Pascoal','120','Centro','Gaspar','SC','300');

insert into tb_compromissos(id,descricao,data,hora,contato_id,local_id)values(10,'Jogar Bocha','2023-12-11','15:00:00',10,20);
insert into tb_compromissos(id,descricao,data,hora,contato_id,local_id)values(20,'Jogar Sinuca','2023-10-10','18:00:00',20,10);