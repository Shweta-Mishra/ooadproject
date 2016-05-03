<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="NameOfProduct1">
				<s:property value="S_stock" />
				<s:property value="S_price" />
			</s:iterator>