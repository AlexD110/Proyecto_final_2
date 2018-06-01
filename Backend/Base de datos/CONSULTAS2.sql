--Solo placa agente
SELECT C.* FROM Comparendo C JOIN Persona P ON(P.Nip=C.Agente) WHERE P.Placa_Agente=1234;
--Solo fecha
SELECT C.* FROM Comparendo C WHERE C.Fecha='06-06-2019';
--Solo nip del infractor
SELECT C.* FROM Comparendo C JOIN Persona P ON(P.Nip=C.Infractor) WHERE C.Infractor='1094956812';
--Solo estado
SELECT C.* FROM Comparendo C WHERE Upper(C.Estado)='HABILITADO';

--Placa y fecha
SELECT C.* FROM Comparendo C JOIN Persona P ON(P.Nip=C.Agente) WHERE P.Placa_Agente=1234 AND C.Fecha='05-06-2018';
--Placa - fecha y nip infractor
SELECT C.* FROM Comparendo C JOIN Persona P ON(P.Nip=C.Agente) WHERE P.Placa_Agente=1234 AND C.Fecha='05-06-2018' AND C.Infractor=1094956812;
--Placa - nip infractor y estado
SELECT C.* FROM Comparendo C JOIN Persona P ON(P.Nip=C.Agente) WHERE P.Placa_Agente=1234 AND C.Infractor=1094956812 AND Upper(C.Estado)='HABILITADO';
--Fecha y nip infractor
SELECT C.* FROM Comparendo C WHERE C.Fecha='05-06-2018' AND C.Infractor=1094956812;
--Fecha y estado
SELECT C.* FROM Comparendo C WHERE C.Fecha='05-06-2018' AND Upper(C.Estado)='HABILITADO';
--Nip infractor y estado
SELECT C.* FROM Comparendo C WHERE C.Infractor=1094956812 AND Upper(C.Estado)='HABILITADO';
--Todos los campos llenos
SELECT C.* FROM Comparendo C JOIN Persona P ON(P.Nip=C.Agente) WHERE P.Placa_Agente=1234 AND C.Fecha='05-06-2018' AND C.Infractor=1094956812 AND Upper(C.Estado)='HABILITADO';

--Traer Precios de comparendos
SELECT (SELECT V.VALOR_SALARIO_MINIMO FROM Valores V)*TF.Salarios_Minimos,C.Id FROM Tipo_Infraccion TF JOIN Comparendo C ON(C.Tipo_Infraccion_Codigo=TF.Codigo);
--traer el valor de los comparendos de la persona
SELECT (SELECT V.VALOR_SALARIO_MINIMO FROM Valores V)*TF.Salarios_Minimos,C.Id FROM Tipo_Infraccion TF JOIN Comparendo C ON(C.Tipo_Infraccion_Codigo=TF.Codigo)
JOIN Persona P ON(P.Nip=C.Infractor) WHERE P.Nip=&ID;