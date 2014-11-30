package org.neuroph.netbeans.imr;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.imageio.spi.IIOServiceProvider;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.netbeans.api.settings.ConvertAsProperties;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.imgrec.ImageRecognitionPlugin;
import org.neuroph.imgrec.image.Image;
import org.neuroph.imgrec.image.ImageFactory;
import org.neuroph.imgrec.image.ImageJ2SE;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.windows.IOProvider;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.neuroph.netbeans.imr//IMR//EN",
autostore = false)
public final class ImgRecTestTopComponent extends TopComponent implements LookupListener {

    private static ImgRecTestTopComponent instance;
    private static final String PREFERRED_ID = "ImgRecTestTopComponent";
    private JFileChooser testImageFileChooser;
    private NeuralNetwork selectedNeuralNetwork;
    private DataSet selectedTrainingSet;
  
    public ImgRecTestTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(ImgRecTestTopComponent.class, "CTL_ImgRecTestTopComponent"));
        setToolTipText(NbBundle.getMessage(ImgRecTestTopComponent.class, "HINT_CTL_ImgRecTestTopComponent"));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        topPanel = new javax.swing.JPanel();
        testDataField = new javax.swing.JTextField();
        testingNetworkField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        selectImageButton = new javax.swing.JButton();
        testAllButton = new javax.swing.JButton();
        centerPanel = new javax.swing.JPanel();
        testImageLabel = new javax.swing.JLabel();

        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(800, 400));
        setName(""); // NOI18N
        setLayout(new java.awt.BorderLayout());

        topPanel.setLayout(new java.awt.GridBagLayout());

        testDataField.setEditable(false);
        testDataField.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        testDataField.setText(org.openide.util.NbBundle.getMessage(ImgRecTestTopComponent.class, "ImgRecTestTopComponent.testDataField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 8, 7, 0);
        topPanel.add(testDataField, gridBagConstraints);

        testingNetworkField.setEditable(false);
        testingNetworkField.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        testingNetworkField.setText(org.openide.util.NbBundle.getMessage(ImgRecTestTopComponent.class, "ImgRecTestTopComponent.testingNetworkField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 195;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 12, 5, 0);
        topPanel.add(testingNetworkField, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ImgRecTestTopComponent.class, "ImgRecTestTopComponent.jLabel2.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 18, 6, 21);
        topPanel.add(jLabel2, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ImgRecTestTopComponent.class, "ImgRecTestTopComponent.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 3, 0);
        topPanel.add(jLabel1, gridBagConstraints);

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        org.openide.awt.Mnemonics.setLocalizedText(selectImageButton, org.openide.util.NbBundle.getMessage(ImgRecTestTopComponent.class, "ImgRecTestTopComponent.selectImageButton.text")); // NOI18N
        selectImageButton.setEnabled(false);
        selectImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(selectImageButton);

        org.openide.awt.Mnemonics.setLocalizedText(testAllButton, org.openide.util.NbBundle.getMessage(ImgRecTestTopComponent.class, "ImgRecTestTopComponent.testAllButton.text")); // NOI18N
        testAllButton.setEnabled(false);
        testAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testAllButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(testAllButton);

        add(buttonPanel, java.awt.BorderLayout.PAGE_END);

        centerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        centerPanel.setAutoscrolls(true);

        testImageLabel.setBackground(new java.awt.Color(255, 255, 255));
        testImageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        centerPanel.add(testImageLabel);

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void selectImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageButtonActionPerformed
        testImage();
}//GEN-LAST:event_selectImageButtonActionPerformed

    private void testAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testAllButtonActionPerformed
     testWholeDataSet();
}//GEN-LAST:event_testAllButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton selectImageButton;
    private javax.swing.JButton testAllButton;
    private javax.swing.JTextField testDataField;
    private javax.swing.JLabel testImageLabel;
    private javax.swing.JTextField testingNetworkField;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized ImgRecTestTopComponent getDefault() {
        if (instance == null) {
            instance = new ImgRecTestTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the IMRTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized ImgRecTestTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(ImgRecTestTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof ImgRecTestTopComponent) {
            return (ImgRecTestTopComponent) win;
        }
        Logger.getLogger(ImgRecTestTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    Lookup.Result<NeuralNetwork> neuralNetResultSets;
    Lookup.Result<DataSet> trainingSetNetResultSets;

    @Override
    public void resultChanged(LookupEvent le) {
        Lookup.Result r = (Lookup.Result) le.getSource();
        Collection c = r.allInstances();
        if (!c.isEmpty()) {
            Object item = c.iterator().next();
            
            if (item instanceof NeuralNetwork) {
                selectedNeuralNetwork = (NeuralNetwork) item;
                testingNetworkField.setText(selectedNeuralNetwork.getLabel());
                selectImageButton.setEnabled(true);
            } else if (item instanceof DataSet) {
                selectedTrainingSet = (DataSet) item;
                testDataField.setText(selectedTrainingSet.getLabel());
                testAllButton.setEnabled(true);
            }
        }
    }

    @Override
    public void componentOpened() {
        neuralNetResultSets = WindowManager.getDefault().findTopComponent("projectTabLogical_tc").getLookup().lookupResult(NeuralNetwork.class);
        neuralNetResultSets.addLookupListener(this);
        
        trainingSetNetResultSets = WindowManager.getDefault().findTopComponent("projectTabLogical_tc").getLookup().lookupResult(DataSet.class);
        trainingSetNetResultSets.addLookupListener(this);        
    }

    @Override
    public void componentClosed() {
        neuralNetResultSets.removeLookupListener(this);
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }


    public void testWholeDataSet() {
        Iterator<DataSetRow> iterator = selectedTrainingSet.iterator();
        StringBuilder sb = new StringBuilder();
        while(iterator.hasNext()) {
            DataSetRow trainingElement = iterator.next();
            selectedNeuralNetwork.setInput(trainingElement.getInput());
            selectedNeuralNetwork.calculate();
            double[] networkOutput = selectedNeuralNetwork.getOutput();
            sb.append(arrayToString(networkOutput) + "\r\n");
        }
        IOProvider.getDefault().getIO("Image Recognition Test", false).getOut().println(sb.toString());

    }

    public void testImage() {
                if (testImageFileChooser == null) {
                    testImageFileChooser = new JFileChooser();
                    testImageFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    testImageFileChooser.setFileFilter(new FileFilter() {
                                    @Override
                                    public boolean accept(File f) {
                                            if(f.isDirectory()) {
                                                    return true;
                                            }
                                            String name = f.getName();
                                            if(name.endsWith(".png") || name.endsWith(".PNG") ||
                                                            name.endsWith(".jpg") || name.endsWith(".JPG")) {
                                                    return true;
                                            }
                                            return false;
                                    }
                                    @Override
                                    public String getDescription() {
                                            // TODO Auto-generated method stub
                                            return null;
                                    }
                            });
                }

            int returnVal = testImageFileChooser.showDialog(null, "Select Image");
            if(returnVal == JFileChooser.APPROVE_OPTION) {
            
            // ovde uzmi fajl i prikazi rezultat testa
            File imgFile = testImageFileChooser.getSelectedFile();
               
                Image img = ImageFactory.getImage(imgFile);
//                scale image here
                testImageLabel.setIcon(new ImageIcon(((ImageJ2SE) img).getBufferedImage()));

                ImageRecognitionPlugin imageRecognition = (ImageRecognitionPlugin)selectedNeuralNetwork.getPlugin(ImageRecognitionPlugin.class);
                
                try {
                
                HashMap<String, Double> output = imageRecognition.recognizeImage(img);

                String outputString = "";
                NumberFormat numberFormat = DecimalFormat.getNumberInstance();
		numberFormat.setMaximumFractionDigits(4);
                Iterator keys = output.keySet().iterator();
                while(keys.hasNext()) {
                    String key = (String)keys.next();
                    outputString += key + " : " + numberFormat.format( output.get(key) ) + "\n";
                }

                //testResultsTextArea.setText(outputString);
                IOProvider.getDefault().getIO("Image Recognition Results", false).getOut().println(outputString);
                } catch(Exception ex) {
                    IOProvider.getDefault().getIO("Image Recognition Results", false).getOut().println(ex.getStackTrace());
                }
        }
    }

//    public void clearTestArea() {
//        testResultsTextArea.setText("");
//    }

    private String arrayToString(double[] a) {
        StringBuilder result = new StringBuilder();
        if (a.length > 0) {
            result.append(a[0]);
            for (int i=1; i<a.length; i++) {
                result.append(a[i] + " ");
            }
        }
        return result.toString();
    }
}