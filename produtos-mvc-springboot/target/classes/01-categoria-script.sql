--DROP TABLE tb_categoria;

CREATE TABLE tb_categoria (
    id_categoria 		NUMBER(10) GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    nome_categoria  	VARCHAR2(256)
);

INSERT INTO tb_categoria (nome_categoria) VALUES ('Notebook');
INSERT INTO tb_categoria (nome_categoria) VALUES ('Smartphone');
INSERT INTO tb_categoria (nome_categoria) VALUES ('TV');
INSERT INTO tb_categoria (nome_categoria) VALUES ('Tablet');

commit;

SELECT * FROM tb_categoria;