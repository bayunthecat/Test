angular.module('testing').component('testList', {
       templateUrl : '/testing/components/testList/template/testList.html',
       controller: function getAvailableTests($http) {
           var testController = this;
           $http.get('/testing/test/getAll/count/10/offset/0').then(
               function success(response) {
                   testController.tests = response.data;
               },
               function error(response) {
                   testController.tests = [];
                   console.error('Request failed');
               }
           );
       }
   });