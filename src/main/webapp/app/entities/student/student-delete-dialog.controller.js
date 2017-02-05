(function() {
    'use strict';

    angular
        .module('cs499A02App')
        .controller('StudentDeleteController',StudentDeleteController);

    StudentDeleteController.$inject = ['$uibModalInstance', 'entity', 'Student'];

    function StudentDeleteController($uibModalInstance, entity, Student) {
        var vm = this;

        vm.student = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Student.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
