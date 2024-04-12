// Citizen interface
interface Citizen {
    void performAction();
}

// Concrete Citizen classes
class Worker implements Citizen {
    @Override
    public void performAction() {
        System.out.println("Worker is working");
    }
}

class Student implements Citizen {
    @Override
    public void performAction() {
        System.out.println("Student is studying");
    }
}

class Retiree implements Citizen {
    @Override
    public void performAction() {
        System.out.println("Retiree is relaxing");
    }
}

// Citizen Factory
class CitizenFactory {
    public Citizen createCitizen(CitizenType type) {
        switch (type) {
            case WORKER:
                return new Worker();
            case STUDENT:
                return new Student();
            case RETIREE:
                return new Retiree();
            default:
                throw new IllegalArgumentException("Invalid citizen type: " + type);
        }
    }
}

// Building interface
interface Building {
    void function();
}

// Concrete Building classes
class ResidentialBuilding implements Building {
    @Override
    public void function() {
        System.out.println("Residential building provides housing");
    }
}

class CommercialBuilding implements Building {
    @Override
    public void function() {
        System.out.println("Commercial building provides services");
    }
}

class IndustrialBuilding implements Building {
    @Override
    public void function() {
        System.out.println("Industrial building facilitates production");
    }
}

// Building Factory
class BuildingFactory {
    public Building createBuilding(BuildingType type) {
        switch (type) {
            case RESIDENTIAL:
                return new ResidentialBuilding();
            case COMMERCIAL:
                return new CommercialBuilding();
            case INDUSTRIAL:
                return new IndustrialBuilding();
            default:
                throw new IllegalArgumentException("Invalid building type: " + type);
        }
    }
}

// Infrastructure interface
interface Infrastructure {
    void operate();
}

// Concrete Infrastructure classes
class Road implements Infrastructure {
    @Override
    public void operate() {
        System.out.println("Road facilitates transportation");
    }
}

class PowerGrid implements Infrastructure {
    @Override
    public void operate() {
        System.out.println("Power grid supplies electricity");
    }
}

class WaterSystem implements Infrastructure {
    @Override
    public void operate() {
        System.out.println("Water system provides water supply");
    }
}

// Infrastructure Factory
class InfrastructureFactory {
    public Infrastructure createInfrastructure(InfrastructureType type) {
        switch (type) {
            case ROAD:
                return new Road();
            case POWER_GRID:
                return new PowerGrid();
            case WATER_SYSTEM:
                return new WaterSystem();
            default:
                throw new IllegalArgumentException("Invalid infrastructure type: " + type);
        }
    }
}

// Singleton Factory Manager
class SingletonFactory {
    private static final SingletonFactory instance = new SingletonFactory();
    private final CitizenFactory citizenFactory = new CitizenFactory();
    private final BuildingFactory buildingFactory = new BuildingFactory();
    private final InfrastructureFactory infrastructureFactory = new InfrastructureFactory();

    private SingletonFactory() {}

    public static SingletonFactory getInstance() {
        return instance;
    }

    public CitizenFactory getCitizenFactory() {
        return citizenFactory;
    }

    public BuildingFactory getBuildingFactory() {
        return buildingFactory;
    }

    public InfrastructureFactory getInfrastructureFactory() {
        return infrastructureFactory;
    }
}

// Enumerations for entity types
enum CitizenType {
    WORKER, STUDENT, RETIREE
}

enum BuildingType {
    RESIDENTIAL, COMMERCIAL, INDUSTRIAL
}

enum InfrastructureType {
    ROAD, POWER_GRID, WATER_SYSTEM
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        SingletonFactory factory = SingletonFactory.getInstance();

        // Creating citizens
        Citizen worker = factory.getCitizenFactory().createCitizen(CitizenType.WORKER);
        Citizen student = factory.getCitizenFactory().createCitizen(CitizenType.STUDENT);
        Citizen retiree = factory.getCitizenFactory().createCitizen(CitizenType.RETIREE);

        // Creating buildings
        Building residentialBuilding = factory.getBuildingFactory().createBuilding(BuildingType.RESIDENTIAL);
        Building commercialBuilding = factory.getBuildingFactory().createBuilding(BuildingType.COMMERCIAL);
        Building industrialBuilding = factory.getBuildingFactory().createBuilding(BuildingType.INDUSTRIAL);

        // Creating infrastructure elements
        Infrastructure road = factory.getInfrastructureFactory().createInfrastructure(InfrastructureType.ROAD);
        Infrastructure powerGrid = factory.getInfrastructureFactory().createInfrastructure(InfrastructureType.POWER_GRID);
        Infrastructure waterSystem = factory.getInfrastructureFactory().createInfrastructure(InfrastructureType.WATER_SYSTEM);

        // Testing
        worker.performAction();
        student.performAction();
        retiree.performAction();

        residentialBuilding.function();
        commercialBuilding.function();
        industrialBuilding.function();

        road.operate();
        powerGrid.operate();
        waterSystem.operate();
    }
}
