(function() {
    'use strict';

    angular
        .module('cs499A02App')
        .controller('SchoolController', SchoolController);

    SchoolController.$inject = ['$scope', '$state', 'School'];

    function SchoolController ($scope, $state, School) {
        var vm = this;

        vm.schools = [];

        loadAll();

        function loadAll() {
            School.query(function(result) {
                vm.schools = result;
                vm.searchQuery = null;
            });
        }
    }
})();
