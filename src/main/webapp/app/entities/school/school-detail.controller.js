(function() {
    'use strict';

    angular
        .module('cs499A02App')
        .controller('SchoolDetailController', SchoolDetailController);

    SchoolDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'School', 'Student', 'Teacher'];

    function SchoolDetailController($scope, $rootScope, $stateParams, previousState, entity, School, Student, Teacher) {
        var vm = this;

        vm.school = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cs499A02App:schoolUpdate', function(event, result) {
            vm.school = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
