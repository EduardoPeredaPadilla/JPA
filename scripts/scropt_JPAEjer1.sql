select *
	from libro;
    
select *
	from autor;

select * 
	from editorial;

/*Agregamos alguno autores*/
insert into autor
	values(1, 1, 'Allan_Poe');
insert into autor
	values(2, 1, 'LoveCraft');
    
/*Agregamos algunas editoriales*/
insert into editorial
	values(1, 1, 'Oscura');
insert into editorial
	values(2, 1, 'Desconocida');

/*Agrgamos algunos libros*/
insert into libro
	values(1, 1, 1845, 10, 0, 10, 'El_Cuervo', 1, 1);
insert into libro
	values(2, 1, 2008, 5, 0, 5, 'El_Necronomicron', 2, 2);
insert into libro
	values(3, 1, 1843, 5, 2, 3, 'El_Gato_Negro', 1, 1);

/*scripts para borrar los agregados despues de ejecutar en VSCode*/
delete
	from libro 
    where ISBN = 12;
delete
	from editorial
    where ID = 7;
delete
	from autor
    where ID = 7;
    
/*test scripts*/
select *
	from autor a
    where a.nombre = 'Allan_Poe';
    
select *
	from libro l
    left join autor a on l.autor_id = a.id
    where a.nombre = 'Allan_Poe';