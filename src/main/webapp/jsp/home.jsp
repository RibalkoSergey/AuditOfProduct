<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>Audit Of Product</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>

  <jsp:include page="include/lib.jsp" />
  <jsp:include page="include/core.jsp" />

  <style type="text/css">
    .blue {
      background: #CBE7F2;
    }
    .white {
      background: #ffffff;
    }
  </style>

</head>

<body ng-app="core" ng-controller="HomeCtrl" ng-init="init()">
  <div style="padding-left: 170px; padding-right: 170px; height: 100%;">
    <div class="wrap">
      <div>
        <jsp:include page="decorator/header.jsp"/>
      </div>

      <div style="background-color: #E9F3FD; border: 1px solid #A8C6E7;">
        <ul class="nav nav-tabs" style="padding: 14px;">
          <button type="button" class="btn btn-sm btn-primary" data-ng-click="create()">
            <span class="glyphicon glyphicon-plus"></span> Create Product
          </button>
        </ul>

        <div style="min-width: 1280px;  width: auto; padding: 10px; background-color: #ffffff;">
          <div>
            <div class="row">
              <div class="col-md-12">
                <div>
                  <table class="table table-bordered" >
                    <thead>
                    <tr class="well">
                      <th class="text-center">Phone Number</th>
                      <th class="text-center">Remained Amount</th>
                      <th class="text-center">Product Code</th>
                      <th class="text-center">Product Name</th>
                      <th class="text-center">Overall Amount</th>
                      <%--<th class="text-center">Rest</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-class="$index%2 == 0 ? 'blue' : 'white'"
                            ng-repeat="item in (items = (products) | pagingFilter:paging.pageSize:(paging.currentPage - 1))">
                      <td style="word-break: break-all">{{item.phoneNumber}}</td>
                      <td>{{item.realizedCount}}</td>
                      <td>{{item.productCode}}</td>
                      <td>{{item.productName}}</td>
                      <td>{{item.generalCount}}</td>
                      <%--<td>{{item.generalCount - item.realizedCount}}</td>--%>
                    </tr>
                    <tr>
                      <td colspan="12" class="text-center" ng-if="items.length == 0">No Data Available</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <div class="text-right">
                  <pagination ng-model="paging.currentPage"
                              total-items="items.length"
                              items-per-page="paging.pageSize"
                              max-size="5"
                              rotate="false"
                              previous-text="&lsaquo;"
                              next-text="&rsaquo;"
                              boundary-links="true"
                              first-text="&laquo;"
                              last-text="&raquo;">
                  </pagination>
                </div>
              </div>
            </div>
        </div>
      </div>
    </div>

    <div class="cm-footer">
      <jsp:include page="decorator/footer.jsp"/>
      <div style="clear: both"></div>
    </div>

  </div>
</body>
</html>