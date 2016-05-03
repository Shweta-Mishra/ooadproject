<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>


						<s:iterator value="products">
											<div class="col-md-4">
												<div class="border">
													<br> <center> <s:if test="%{stock == 0}">
															<a href="#"> <img src="<s:property value="image"/>"
																alt="<s:property value="product_id"/>" height="140px"
																width="auto"><br> <img
																		src="images/sold_out.jpg" alt="outofstock"
																		height="40px"></a>
														</s:if> <s:if test="%{stock != 0}">
															<s:if test="%{stock >= 0}">

																<a
																	href="productSample?pid=<s:property value="product_id"/>">
																	<img src="<s:property value="image"/>"
																	alt="<s:property value="product_id"/>" height="140px">
																		<br> <br> <br>
																</a>
															</s:if>
															<s:if test="%{stock < 0}">
																<a href="#"> <img src="<s:property value="image"/>"
																	alt="<s:property value="product_id"/>" height="140px"
																	width="auto"><br> <img
																			src="images/sold_out.jpg" alt="outofstock"
																			height="40px"></a>
															</s:if>
														</s:if>
														<div class="giveMeEllipsis">
															<a
																href="productSample?pid=<s:property value="product_id"/>">
																<font size="4" color="black"> <s:property
																	value="product_name" /></font><br>
															</a>
														</div>
														<div class="giveMeEllisis">
															<font size="1" color="black"> <s:property
																value="product_description" /></font><br>
														</div>
														<hr>
															<div style="height: 50px">

																<font size="5px" color="#76553B"> Rs. <s:property
																	value="price" /> <br><br></font>

															</div>
															<hr>




																<br> <br> <br>
														</center>
												</div>
												<br>
											</div>
										</s:iterator>


