import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Nathan on 3/22/14.
 */
public class ControlPanel extends JPanel implements ActionListener
{
    int timeStart = (int) new Date().getTime();
    int currentTime = (int) new Date().getTime();
    double bankTotalSeconds = 0;
    DecimalFormat df = new DecimalFormat("#.##");

    JButton addThread;
    JButton removeThread;
    String[] txns = new String[10]; //rate of transactions added to queue

    JComboBox txnChoice;

    JLabel timeSinceStartLabel;
    JLabel averageForSystem;
    JLabel chooseThreads;
    JLabel chooseTxn;
    JLabel requestLabel;
    JLabel threadCount;
    JLabel responseQueueSize;
    JLabel space;
    String BofA = ("Bank of America");
    JLabel BofALabel;
    JLabel BofAAverage;
    Bank tempBofA;
    String Citi = ("Citi");
    JLabel CitiLabel;
    JLabel CitiAverage;
    Bank tempCiti;
    String Chase = ("Chase");
    JLabel ChaseLabel;
    JLabel ChaseAverage;
    Bank tempChase;
    String wFargo = ("Wells Fargo");
    JLabel wFargoLabel;
    JLabel wFargoAverage;
    Bank tempwFargo;


    int queueSize = 0;
    Timer timer;
    int txnRate = 0;



    public ControlPanel ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        timer = new Timer(1000, this);
        timer.start();
        requestLabel = new JLabel("Number of transactions in request queue: " + queueSize);
        chooseTxn = new JLabel("Select rate of transactions added to the queue (1 = fastest, 10 = slowest): ");
        chooseThreads = new JLabel("Select the number of threads to add: ");
        threadCount = new JLabel("Number of threads added: ");
        responseQueueSize = new JLabel("Number of transactions in response queue: ");
        space = new JLabel(" ");

        addThread = new JButton("Add Thread");
        addThread.addActionListener(this);
        removeThread = new JButton("Remove Thread");
        removeThread.addActionListener(this);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 0;
        add(chooseTxn, c);

        for(int i = 1; i < 11; i++)
        {
            txns[i-1] = String.valueOf(i);
        }
        txnChoice = new JComboBox(txns);
        txnChoice.setSelectedIndex(4);


        txnChoice.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 1;
        c.gridy = 0;
        add(txnChoice);
        txnChoice.setVisible(true);
        space.setVisible(true);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 1;
        add(requestLabel, c);

        requestLabel.setVisible(true);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        add(addThread, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 2;
        add(removeThread, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        add(threadCount, c);
        responseQueueSize.setVisible(true);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        add(responseQueueSize, c);

        //show time since beginning of program
        timeSinceStartLabel = new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 5;
        add(timeSinceStartLabel, c);

        //List Bank information
        //Bank of America
        BofALabel = new JLabel(BofA);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 6;
        add(BofALabel, c);
        tempBofA = Simulation.getBank(BofA);
        BofAAverage = new JLabel("Average time: " + (double)(tempBofA.randTotal/tempBofA.timesCalled));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        BofAAverage.setVisible(true);
        add(BofAAverage, c);


        //Citi Bank
        CitiLabel = new JLabel(Citi);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 8;
        add(CitiLabel, c);
        tempCiti = Simulation.getBank(Citi);
        CitiAverage = new JLabel("Average time: " + (double)(tempCiti.randTotal/tempCiti.timesCalled));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 9;
        CitiAverage.setVisible(true);
        add(CitiAverage, c);

        //Chase Bank
        ChaseLabel = new JLabel(Chase);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 10;
        add(ChaseLabel, c);
        tempChase = Simulation.getBank(Chase);
        ChaseAverage = new JLabel("Average time: " + (double)(tempChase.randTotal/tempChase.timesCalled));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 11;
        ChaseAverage.setVisible(true);
        add(ChaseAverage, c);

        //Wells Fargo Bank
        wFargoLabel = new JLabel(wFargo);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 12;
        add(wFargoLabel, c);
        tempwFargo = Simulation.getBank(wFargo);
        wFargoAverage = new JLabel("Average time: " + (double)(tempwFargo.randTotal/tempwFargo.timesCalled));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 13;
        wFargoAverage.setVisible(true);
        add(wFargoAverage, c);

        //show time since beginning of program
        averageForSystem = new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 14;
        add(averageForSystem, c);

    }

    public void actionPerformed(ActionEvent e)
    {


        if (e.getSource() == removeThread)
        {
            if (Simulation.threadManager.workerList.size() >= 1)
                Simulation.threadManager.removeThread();
        }
        else if (e.getSource() == txnChoice)
        {
            String choice = (String)txnChoice.getSelectedItem();
            int intChoice = Integer.valueOf(choice);

            Simulation.transactionRate = (intChoice * 1000); ///////////////////////////////////////////////

        }
        else if(e.getSource() == addThread)
        {
            Simulation.threadManager.addThread();
        }

        repaint();

    }

    public void paintComponent(Graphics gContext)
    {
        Graphics2D g2 = (Graphics2D) gContext;
        super.paintComponent(g2);
        queueSize = Simulation.requestQueue.size();

        requestLabel.setText("Number of transactions in request queue: " + queueSize);

        threadCount.setText("Number of threads in WorkerList queue: " + Simulation.threadManager.workerList.size());

        responseQueueSize.setText("Number of transactions processed: " + Simulation.responseQueue.size());

        currentTime = (int) new Date().getTime();
        timeSinceStartLabel.setText("Time elapsed since the start of the program: " + ((currentTime - timeStart)/1000));


        //Bank average times
        tempBofA = Simulation.getBank(BofA);
        BofAAverage.setText("B of A average time: " + df.format((double) (tempBofA.randTotal / tempBofA.timesCalled)));
        tempCiti = Simulation.getBank(Citi);
        CitiAverage.setText("Citi average time: " + df.format((double) (tempCiti.randTotal / tempCiti.timesCalled)));
        tempChase = Simulation.getBank(Chase);
        ChaseAverage.setText("Chase average time: " + df.format((double) (tempChase.randTotal / tempChase.timesCalled)));
        tempwFargo = Simulation.getBank(wFargo);
        wFargoAverage.setText("Wells Fargo average time: " + df.format((double) (tempwFargo.randTotal / tempwFargo.timesCalled)));

        //
        bankTotalSeconds = (tempBofA.randTotal + tempCiti.randTotal + tempChase.randTotal + tempwFargo.randTotal);
        averageForSystem.setText("Average number of transactions handled per second for the system: "  +
                df.format((bankTotalSeconds/((currentTime - timeStart)/1000))));

    }
}
