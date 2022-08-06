import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Dataset {


    public static void x(String stationA, String stationB)
    {
        GraphWeighted graphWeighted = new GraphWeighted(true);
        NodeWeighted BAKER_STREET = new NodeWeighted(1, "BAKER_STREET");
        NodeWeighted REGENTS_PARK = new NodeWeighted(2, "REGENTS_PARK");
        NodeWeighted OXFORD_CIRCUS = new NodeWeighted(3, "OXFORD_CIRCUS");
        NodeWeighted PICCADILLY_CIRCUS = new NodeWeighted(4, "PICCADILLY_CIRCUS");
        NodeWeighted CHARING_CROSS = new NodeWeighted(5, "CHARING_CROSS");
        NodeWeighted EMBANKMENT = new NodeWeighted(6, "EMBANKMENT");
        NodeWeighted NOTTING_HILL_GATE = new NodeWeighted(7, "NOTTING_HILL_GATE");
        NodeWeighted QUEENSWAY = new NodeWeighted(8, "QUEENSWAY");
        NodeWeighted LANCASTER_GATE = new NodeWeighted(9, "LANCASTER_GATE");
        NodeWeighted MARBLE_ARCH = new NodeWeighted(10, "MARBLE_ARCH");
        NodeWeighted BOND_STREET = new NodeWeighted(11, "BOND_STREET");
        NodeWeighted TOTTENHAM_COURT_ROAD = new NodeWeighted(12, "TOTTENHAM_COURT_ROAD");
        NodeWeighted HOLBORN = new NodeWeighted(13, "HOLBORN");
        NodeWeighted CHANCERY_LANE = new NodeWeighted(14, "CHANCERY_LANE");
        NodeWeighted ST_PAULS = new NodeWeighted(15, "ST_PAULS");
        NodeWeighted BANK = new NodeWeighted(16, "BANK");
        NodeWeighted LIVERPOOL_STREET = new NodeWeighted(17, "LIVERPOOL_STREET");
        NodeWeighted PADDINGTON  = new NodeWeighted(18, "PADDINGTON");
        NodeWeighted EDGWARE_ROAD = new NodeWeighted(19, "EDGWARE ROAD");
        NodeWeighted GREAT_PORTLAND_STREET = new NodeWeighted(20, "GREAT_PORTLAND_STREET");
        NodeWeighted EUSTON_SQUARE = new NodeWeighted(2, "EUSTON_SQUARE");
        NodeWeighted KINGS_CROSS_ST_PANCRAS = new NodeWeighted(22, "KINGS_CROSS_ST_PANCRAS");
        NodeWeighted FARRINGDON = new NodeWeighted(23, "FARRINGDON");
        NodeWeighted BARBICAN = new NodeWeighted(24, "BARBICAN");
        NodeWeighted MOORGATE = new NodeWeighted(25, "MOORGATE");
        NodeWeighted ALDGATE = new NodeWeighted(26, "ALDGATE");
        NodeWeighted TOWER_HILL = new NodeWeighted(27, "TOWER_HILL");
        NodeWeighted MONUMENT = new NodeWeighted(28, "MONUMENT");
        NodeWeighted CANNON_STREET = new NodeWeighted(29, "CANNON_STREET");
        NodeWeighted MANSION_HOUSE = new NodeWeighted(30, "MANSION_HOUSE");
        NodeWeighted BLACKFRIARS = new NodeWeighted(31, "BLACKFRIARS");
        NodeWeighted TEMPLE = new NodeWeighted(32, "TEMPLE");
        NodeWeighted WESTMINSTER = new NodeWeighted(33, "WESTMINSTER");
        NodeWeighted ST_JAMES_PARK = new NodeWeighted(34, "ST_JAMES_PARK");
        NodeWeighted VICTORIA = new NodeWeighted(35, "VICTORIA");
        NodeWeighted SLOANE_SQUARE = new NodeWeighted(36, "SLOANE_SQUARE");
        NodeWeighted SOUTH_KENSINGTON = new NodeWeighted(37, "SOUTH_KENSINGTON");
        NodeWeighted GLOUCESTER_ROAD = new NodeWeighted(38, "GLOUCESTER_ROAD");
        NodeWeighted HIGH_STREET_KENSINGTON = new NodeWeighted(39, "HIGH_STREET_KENSINGTON");
        NodeWeighted BAYSWATER = new NodeWeighted(40, "BAYSWATER");
        // Our addEdge method automatically adds Nodes as well.
        // The addNode method is only there for unconnected Nodes,
        // if we wish to add any
        graphWeighted.addEdge(BAKER_STREET, REGENTS_PARK, 1.68);
        graphWeighted.addEdge(REGENTS_PARK, OXFORD_CIRCUS, 1.85);
        graphWeighted.addEdge(OXFORD_CIRCUS, PICCADILLY_CIRCUS, 1.95);
        graphWeighted.addEdge(PICCADILLY_CIRCUS, CHARING_CROSS, 1.35);
        graphWeighted.addEdge(CHARING_CROSS, EMBANKMENT, 0.95);

        graphWeighted.addEdge(NOTTING_HILL_GATE, QUEENSWAY, 1.17);
        graphWeighted.addEdge(QUEENSWAY, LANCASTER_GATE, 1.35);
        graphWeighted.addEdge(LANCASTER_GATE, MARBLE_ARCH, 1.92);
        graphWeighted.addEdge(MARBLE_ARCH, BOND_STREET, 1.00);
        graphWeighted.addEdge(BOND_STREET, OXFORD_CIRCUS, 1.10);
        graphWeighted.addEdge(OXFORD_CIRCUS, TOTTENHAM_COURT_ROAD, 0.98);
        graphWeighted.addEdge(TOTTENHAM_COURT_ROAD, HOLBORN, 1.63);
        graphWeighted.addEdge(HOLBORN, CHANCERY_LANE, 0.87);
        graphWeighted.addEdge(CHANCERY_LANE, ST_PAULS, 1.52);
        graphWeighted.addEdge(ST_PAULS, BANK, 1.62);
        graphWeighted.addEdge(BANK, LIVERPOOL_STREET, 1.60);

        graphWeighted.addEdge(PADDINGTON, EDGWARE_ROAD, 2.33);
        graphWeighted.addEdge(EDGWARE_ROAD, BAKER_STREET, 1.47);
        graphWeighted.addEdge(BAKER_STREET, GREAT_PORTLAND_STREET, 1.90);
        graphWeighted.addEdge(GREAT_PORTLAND_STREET, EUSTON_SQUARE, 1.25);
        graphWeighted.addEdge(EUSTON_SQUARE, KINGS_CROSS_ST_PANCRAS, 1.75);
        graphWeighted.addEdge(KINGS_CROSS_ST_PANCRAS, FARRINGDON, 2.98);
        graphWeighted.addEdge(FARRINGDON, BARBICAN, 1.22);
        graphWeighted.addEdge(BARBICAN, MOORGATE, 1.32);
        graphWeighted.addEdge(MOORGATE, LIVERPOOL_STREET, 1.18);
        graphWeighted.addEdge(LIVERPOOL_STREET, ALDGATE, 2.18);
        graphWeighted.addEdge(ALDGATE, TOWER_HILL, 1.37);
        graphWeighted.addEdge(TOWER_HILL, MONUMENT, 1.48);
        graphWeighted.addEdge(MONUMENT, CANNON_STREET, 0.88);
        graphWeighted.addEdge(CANNON_STREET, MANSION_HOUSE, 0.93);
        graphWeighted.addEdge(MANSION_HOUSE, BLACKFRIARS, 1.22);
        graphWeighted.addEdge(BLACKFRIARS, TEMPLE, 1.37);
        graphWeighted.addEdge(TEMPLE, EMBANKMENT, 1.43);
        graphWeighted.addEdge(EMBANKMENT, WESTMINSTER, 1.40);
        graphWeighted.addEdge(WESTMINSTER, ST_JAMES_PARK, 1.52);
        graphWeighted.addEdge(ST_JAMES_PARK, VICTORIA, 1.33);
        graphWeighted.addEdge(VICTORIA, SLOANE_SQUARE, 1.75);
        graphWeighted.addEdge(SLOANE_SQUARE, SOUTH_KENSINGTON, 2.00);
        graphWeighted.addEdge(SOUTH_KENSINGTON, GLOUCESTER_ROAD, 1.48);
        graphWeighted.addEdge(GLOUCESTER_ROAD, HIGH_STREET_KENSINGTON, 2.23);
        graphWeighted.addEdge(HIGH_STREET_KENSINGTON, NOTTING_HILL_GATE, 1.68);
        graphWeighted.addEdge(NOTTING_HILL_GATE, BAYSWATER, 1.77);
        graphWeighted.addEdge(BAYSWATER, PADDINGTON , 1.63);

        graphWeighted.Search(stationA, stationB);
    }
}
