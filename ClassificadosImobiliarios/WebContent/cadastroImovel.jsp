<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>HueHueBR Anuncios Imobiliarios</title>
</head>
<body>
	<f:view>
		<h3>Cadastro de Novo An�ncio</h3>
		<h:form>

			<h:panelGrid border="1" columns="2">
				<h:outputText value="Descri��o"></h:outputText>
				<h:inputText value="#{anuncioMB.anuncio.conteudo}"></h:inputText>
				<h:outputText value="Metragem"></h:outputText>
				<h:inputText value="#{anuncioMB.anuncio.metragem}"></h:inputText>
				<h:outputText value="Num.Quartos"></h:outputText>
				<h:inputText value="#{anuncioMB.anuncio.numeroDeQuartos}"></h:inputText>
				<h:outputText value="Bairro"></h:outputText>
				<h:inputText value="#{anuncioMB.anuncio.bairro}"></h:inputText>
			</h:panelGrid>
			<br /><h:commandButton value="Cadastrar" action="#{anuncioMB.criarAnuncio}">
			</h:commandButton>
		</h:form>
	</f:view>
</body>
</html>