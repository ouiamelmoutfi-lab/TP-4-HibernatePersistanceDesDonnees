package services;

import dao.MachineDao;
import entities.Machine;
import entities.Salle;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MachineServiceTest {
    @Test
    public void testCrudMachine() {
        SalleService salleService = new SalleService();
        MachineService service = new MachineService();
        Salle salle = new Salle("S4", "Salle des machines");
        Assertions.assertTrue(salleService.create(salle));

        Machine machine = new Machine();
        machine.setRef("M-202");
        machine.setMarque("HP");
        machine.setSalle(salle);
        Assertions.assertTrue(service.create(machine));
        Machine trouvee = service.getById(machine.getId());
        Assertions.assertNotNull(trouvee);
        Assertions.assertEquals(salle.getId(), trouvee.getSalle().getId());
        Assertions.assertFalse(service.getAll().isEmpty());

        machine.setMarque("Dell");
        Assertions.assertTrue(service.update(machine));
        Assertions.assertEquals("Dell", service.getById(machine.getId()).getMarque());

        Assertions.assertTrue(service.delete(machine));
        Assertions.assertNull(service.getById(machine.getId()));
        Assertions.assertTrue(salleService.delete(salle));
    }

    @Test
    public void testFindByMarque() {
        SalleService salleService = new SalleService();
        MachineService service = new MachineService();
        Salle salle = new Salle("S5", "Salle HQL");
        Assertions.assertTrue(salleService.create(salle));

        Machine machine = new Machine();
        machine.setRef("M-303");
        machine.setMarque("Dell");
        machine.setSalle(salle);
        Assertions.assertTrue(service.create(machine));

        MachineDao dao = new MachineDao();
        List<Machine> machines = dao.findByMarque("Dell");
        Assertions.assertFalse(machines.isEmpty());
        for (Machine resultat : machines) {
            Assertions.assertEquals("Dell", resultat.getMarque());
        }

        Assertions.assertTrue(service.delete(machine));
        Assertions.assertTrue(salleService.delete(salle));
    }
}
