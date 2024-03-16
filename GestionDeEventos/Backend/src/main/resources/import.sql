INSERT INTO costo_evento (precio,descripcion) VALUES (55,"asdasd");
INSERT INTO costo_evento (precio,descripcion) VALUES (10,"descripcion");

INSERT INTO participante (nombre, apellido, dni, correo, telefono) VALUES ('Juan', 'Pérez', '123456789', 'juanperez@example.com', '987654321');

INSERT INTO cliente (nombre, telefono, correo, direccion) VALUES ('[Cliente Name]', '[Phone Number]', 'asdasda@example.com', '[Cliente Address]');

INSERT INTO repositorio (video, descripcion, archivos, fecha) VALUES ('[Video URL]', '[Description]', '[Files]', '2022-01-15');

INSERT INTO usuario (nombre, apellidos, clave) VALUES ('[User Name]', '[User Last Name]', '[Hashed Password]');

INSERT INTO evento_predefinido (titulo, hora_inicio, hora_fin, color_texto, color_fondo, id_usuario) VALUES ('[Event Title]', '2024-03-16T10:00:00', '2024-03-16T12:00:00', '[Text Color]', '[Background Color]',1);

INSERT INTO evento (titulo, fecha_inicio, fecha_fin, hora_inicio, hora_fin, descripcion, poster, id_usuario, id_repositorio) VALUES ('[Event Title]', '2024-03-16', '2024-03-18', '2024-03-16T10:00:00', '2024-03-16T12:00:00', '[Description]', '[Poster URL]', 1, 1);

INSERT INTO facturacion (fecha, id_cliente, id_costo, id_evento,id_predefinido) VALUES ('2024-03-16', 1, 1, 1,1);
