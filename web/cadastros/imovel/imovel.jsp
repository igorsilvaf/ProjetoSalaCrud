<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
          
         <h2>Veiculos</h2>
         <table id="datatable" class="display">
             <thead>
                 <tr>
                     <th align="left">ID</th>
                     <th align="left">Descricao</th>
                     <th align="left">Endereco</th>
                     <th align="left">ValorAlugel</th>
                     <th align="right"></th>
                     <th align="right"></th>
                      <th align="right"></th>
                 </tr>
             </thead>
             <tbody>
                 <c:forEach var="imovel" items="${imovel}">
                     <tr>
                         <td align="left">${imovel.idImovel}</td>
                         <td align="left">${imovel.descricao}</td>
                         <td align="left">${imovel.endereco}</td>
                         <td align="left">${imovel.valorAluguel}</td>
                         <td align="center">
                             <a href="${pageContext.request.contextPath}/ImovelExcluir?idImovel=${imovel.idImovel}">Excluir</a>
                         </td>
                         
                         <td align="center">
                             <a href="${pageContext.request.contextPath}/ImovelCarregar?idImovel=${imovel.idImovel}">Alterar</a>
                         </td>
                     </tr>
                 </c:forEach>
             </tbody>
             
         </table>
         <div align="center">
             <a href="${pageContext.request.contextPath}/ImovelNovo">Novo</a>
             <a href="index.jsp">Voltar à página Inicial</a>
                          <!--  cadastro / veiculo / Veiculo.jsp --> 

         </div>
           
            
             <script>
                  $(Document).ready(function (){
                     console.log('Entrei ready');
                     
                 $('#datatable').DataTable({
                     "oLanguage":{
                         "sProcessing": "Processando...",
                         "sLengthMenu": "Mostrar _MENU_ Registro",
                         "sZeroRecords": "Nehum registro encontrado",
                         "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                         "sInfoEmpty": "Monstrando de 0 até 0 de 0 registros",
                         "sInfoFiltered": "",
                         "sInfoPostFix": "",
                         "sSearch": "Buscar:",
                         "sUrl": "",
                         "oPaginate":{
                                         

                             "sFirst": "Primeiro",
                             "sPrevious": "Anterior",
                             "sNext": "Seguinte",
                             "sLast": "Último"
                             
                         }
                     }
                     });  
                 });
             </script>          
             
             <%@include file="/footer.jsp" %>
             