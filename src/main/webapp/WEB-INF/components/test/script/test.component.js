angular.module('testing').component('test', {
    templateUrl : '/testing/components/test/template/test.html',
    controller: function getAvailableTests($http) {
        var testController = this;
        $http.get('/testing/test/get/6').then(
            function success(response) {
                testController.test = response.data;
            },
            function error(response) {
                testController.test = [];
                console.error('Request failed');
            }
        );
    }
});