INSERT INTO USUARIO(nome, email, senha) VALUES('Danilo', 'danilo@email.com', '123456');
INSERT INTO USUARIO(nome, email, senha) VALUES('Andre', 'Andre@email.com', '123456');

INSERT INTO PRODUTO(descricao, status, fabricante, marca, familia, codigo_de_barras, preco_de_fabrica, preco_de_venda, preco_promocional, observacao, usuario_id) VALUES('Caneta Azul','ATIVO', 'Bic LTDA', 'Bic', 'canetas', '78912223333','1,00','2,00', '0,75', 'produto veio de revenda', 1);



/*
private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusProduto status = StatusProduto.ATIVO;
	private String fabricante;
	private String marca;
	private String familia;
	private String codigoDeBarras;
	private String precoDeFabrica;
	private String precoDeVenda;
	private String precoPromocional;
	private String observação;
	//private LocalDateTime dataCriacao;
	@ManyToOne
	private Usuario usuario;
	
	
/*
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) 
VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);*/
