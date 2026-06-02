package healthhabitrecorder;
import java.util.*;
import java.io.*;
public class HealthHabitRecorder 
{
    static Scanner input=new Scanner(System.in);
    static ArrayList<String> healthData=new ArrayList<>();
    static final String file="healthData.txt";
    public static void main(String[] args)
    {
        loadDataFromFile();
        while(true)
        {
            mainMenu();
            System.out.print("Enter your choice: ");
            int choice=0;
            try{
                choice=input.nextInt();
                input.nextLine();
            }catch(InputMismatchException e)
            {
                System.out.println("ERROR Enter numbers only!");
                input.nextLine();
                continue;
            }
            switch(choice)
            {
                case 1:
                    recordHealthHabit();
                    break;
                case 2:
                    viewRecords();
                    break;
                 case 3:
                    filterRecord();
                    break;
                 case 4:
                    analyzePerformance();
                    break;
                 case 5:
                    save();
                    break;
                 case 6:
                     System.out.println("Thankyou for using Health Habit Recorder!Stay Healthy");
                     return;
                default:
                    System.out.println("Invalid Option!Please enter from 1-6");                   
            }
        }
    }
    public static void mainMenu()
    {
        System.out.println("<<<HEALTH HABIT RECORDER>>>");
        System.out.println("MAIN MENU:");
        System.out.println("1.Record New Health Data");
        System.out.println("2.View All Records");
        System.out.println("3.Filter Records");
        System.out.println("4.Analyze Performance");
        System.out.println("5.Save Record");
        System.out.println("6.Exit");
    }
    public static void recordHealthHabit()
    {
        String name="";
        int age=0;
        String gender="";
        int water=0;
        int sleep=0;
        int exercise=0;
        double height=0;
        double weight=0;
        int systolic=0;
        int diastolic=0;
        int sugar=0;
        while(true)
        {
            try
            {
            System.out.print("Name: ");
            name=input.nextLine();
            if(name.isEmpty())
                throw new IllegalArgumentException("Name cannot be empty!");
            break;
            }catch(Exception e) 
            {
                System.out.println("ERROR: "+e.getMessage());
                System.out.println("Please enter the name again.");
            }    
        }
        while(true)
        {
            try
            {
            System.out.print("Age(years): ");
            age=input.nextInt();
            input.nextLine();
            if(age<=0||age>120)
                throw new IllegalArgumentException("Age must be between 1 and 120!!");
            break;
            }catch(InputMismatchException e) 
            {
                System.out.println("ERROR: Please enter a valid number"); 
                input.nextLine();
            }
            catch (IllegalArgumentException e)
            {
            System.out.println("ERROR: "+e.getMessage());
            }
        }
        while(true)
        {
            try
            {
            System.out.print("Gender(M/F): ");
            gender=input.nextLine().toUpperCase();
            if(!gender.equals("M")&&!gender.equals("F"))
                throw new IllegalArgumentException("Gender must be M or F!");
            break;
            }catch(Exception e) 
            {
                System.out.println("ERROR: "+e.getMessage()); 
            }    
         }
        while(true)
        {
            try
            {
            System.out.print("Water consumed(glasses): ");
            water=input.nextInt();
            input.nextLine();
            if(water<0)
                throw new IllegalArgumentException("Water intake cannot be negative!");
            if(water>30)
                throw new IllegalArgumentException("Water intake seems unrealistic!Must be below 30 glasses.");
            break;
            }catch (InputMismatchException e) {
                System.out.println("ERROR: Enter a valid number!");
                input.nextLine();
            }catch (IllegalArgumentException e) {
                System.out.println("ERROR: "+e.getMessage());
            }       
        }    
        while(true) 
        {
            try 
            {
            System.out.print("Sleep hours: ");
            sleep=input.nextInt();
            input.nextLine();
            if(sleep<0||sleep>24)
                throw new IllegalArgumentException("Invalid sleep hours!");
            break;
            }catch(InputMismatchException e) {
                System.out.println("ERROR: Enter a valid number!");
                input.nextLine();
            }catch(IllegalArgumentException e) {
                System.out.println("ERROR: "+e.getMessage());
            }
         }
         while(true) 
         {
            try 
            {
                System.out.print("Exercise time(minutes): ");
                exercise=input.nextInt();
                input.nextLine();
                if(exercise<0)
                    throw new IllegalArgumentException("Exercise time cannot be negative!");
                if(exercise>1440)
                throw new IllegalArgumentException("Exercise time cannot exceed 1440 minutes(24 hours!");
                break;
            }catch(InputMismatchException e) {
                System.out.println("ERROR: Enter a valid number!");
                input.nextLine();
            }catch(IllegalArgumentException e) {
                System.out.println("ERROR: " +e.getMessage());
            }
         }
          while(true) 
          {
            try 
            {
                System.out.print("Height(in meters): ");
                height=input.nextDouble();
                input.nextLine();
                if(height<=0)
                    throw new IllegalArgumentException("Height must be positive!");
                if(height<0.5||height>3.0)
                throw new IllegalArgumentException("Height must be between 0.5 and 3.0 meters!");
                break;
            }catch(InputMismatchException e) {
                System.out.println("ERROR: Enter a valid number!");
                input.nextLine();
            }catch(IllegalArgumentException e) {
                System.out.println("ERROR: "+e.getMessage());
            }
        }
       while(true) 
       {
            try {
                System.out.print("Weight(in kg): ");
                weight=input.nextDouble();
                input.nextLine();
                if(weight<=0)
                    throw new IllegalArgumentException("Weight must be positive!");
                if(weight<20||weight>400)
                throw new IllegalArgumentException("Weight must be between 20 and 400 kg!");
                break;
            }catch(InputMismatchException e){
                System.out.println("ERROR: Enter a valid number!");
                input.nextLine();
            }catch(IllegalArgumentException e){
                System.out.println("ERROR: "+e.getMessage());
            }
        }
        while(true)
        {
            try
            {
                System.out.print("Systolic Blood Pressure: ");
                systolic=input.nextInt();
                input.nextLine();
                if(systolic<=0)
                    throw new IllegalArgumentException("BP must be positive!");
                if(systolic>250)
                throw new IllegalArgumentException("Systolic BP must be below 250 mmHg!");
                break;
            }catch(InputMismatchException e){
                System.out.println("ERROR: Enter a valid number!");
                input.nextLine();
            }catch(IllegalArgumentException e){
            System.out.println("ERROR: "+e.getMessage());
            }
        }
        while(true) 
        {
            try {
                System.out.print("Diastolic Blood Pressure: ");
                diastolic=input.nextInt();
                input.nextLine();
                if(diastolic<=0)
                    throw new IllegalArgumentException("BP must be positive!");
                if(diastolic>150)
                throw new IllegalArgumentException("Diastolic BP must be below 150 mmHg!");
                break;
            }catch(InputMismatchException e){
                System.out.println("ERROR: Enter a valid number!");
                input.nextLine();
            }catch(IllegalArgumentException e){
                System.out.println("ERROR: "+e.getMessage());
            }
        }
        while(true) 
        {
            try
            {
                System.out.print("Blood Sugar (mg/dL): ");
                sugar =input.nextInt();
                input.nextLine();
                if(sugar<=0)
                    throw new IllegalArgumentException("Blood sugar must be positive!");
                if(sugar>600)
                throw new IllegalArgumentException("Blood sugar must be below 600 mg/dL!");
                break;
            }catch(InputMismatchException e){
                System.out.println("ERROR: Enter a valid number!");
                input.nextLine();
            } catch(IllegalArgumentException e){
                System.out.println("ERROR: "+e.getMessage());
            }
        }
        double bmi=calculateBMI(weight,height);
        String bmiCategory=categorizeBMI(bmi);
        String bpCategory=categorizeBloodPressure(systolic,diastolic,age);
        String sugarCategory=categorizeSugar(sugar);
        double healthScore=healthScore(water,sleep,exercise,bmi,bpCategory,sugar,age);
        System.out.println("\n========== Your Results ==========");
        System.out.printf("Body Mass Index: %.2f\n",bmi);
        System.out.printf("BMI Category: %s\n",bmiCategory);
        System.out.println("Blood Pressure: "+systolic+"/"+diastolic+"("+bpCategory+")");
        System.out.println("Blood Sugar: "+sugar+"mg/dL ("+sugarCategory+")"); 
        System.out.printf("Health Score:%.1f/100\n",healthScore);
        healthTips(bmi,systolic,diastolic,sugar,age,gender);
        String record= name+","+age+","+gender+","+water+","+sleep+","+exercise+","+height+","+weight+","+systolic+","+diastolic+","+sugar+","+String.format("%.2f",bmi)+","+bmiCategory+","+bpCategory+","+sugarCategory+","+String.format("%.1f",healthScore);
        healthData.add(record);
        System.out.println("\n Health record saved successfully!");
      } 
    public static double calculateBMI(double weight,double height)
    {
        return weight/(height*height);
    }
    public static String categorizeBMI(double bmi)
    {
        if(bmi<18.5)
            return "Underweight";
        else if(bmi>=18.5&&bmi<25)
            return "Normal";
        else if(bmi>=25&&bmi<30)
            return "Overweight";
        else
            return "Obese";
    }
    public static String categorizeBloodPressure(int systolic,int diastolic,int age)
    {
        int normalSystolicMin,normalSystolicMax;
        int normalDiastolicMin,normalDiastolicMax;
         if(age<30)
         {
            normalSystolicMin=100;
            normalSystolicMax=130;
            normalDiastolicMin=60;
            normalDiastolicMax=85;
         } 
         else if(age<=59)
         {
            normalSystolicMin=105;
            normalSystolicMax=135;
            normalDiastolicMin=65;
            normalDiastolicMax=90;
         } 
         else 
         {
            normalSystolicMin=110;
            normalSystolicMax=145;
            normalDiastolicMin=70;
            normalDiastolicMax=95;
        }
       if(systolic<normalSystolicMin||diastolic<normalDiastolicMin)
           return "Low";
        if(systolic>normalSystolicMax||diastolic>normalDiastolicMax)
            return "High";
        return "Normal";
    }
     public static String categorizeSugar(int sugar) 
     {
        if(sugar<70)
            return "Low";
        else if(sugar<=125)
            return "Normal";
        else
            return "High";
      }
      public static int healthScore(int water,int sleep,int exercise,double bmi,String bpCategory,int sugar,int age)
      {
         int score=0;
         if(water>=8)
             score+=15;
         else if(water>=5)
             score+=10;
         else
             score+=5;
         
         if(sleep>=7&&sleep<=9)
             score+=15;
         else if(sleep>=5)
             score+=10;
         else
             score+=5;
         
         if(exercise>=30)
             score+=20;
         else if(exercise>=15)
             score+=10;
         else
             score+=5;
         
         if(bmi>=18.5&&bmi<25)
            score+=20;
         else if((bmi>=17&&bmi<18.5)||(bmi>=25&&bmi<27))
            score+=10;
         else
            score += 5;
        
         if(bpCategory.equals("Normal"))
            score+=15;
         else
            score+=5;
        
         if(sugar>=70&&sugar<=125)
            score+=15;
         else if(sugar>125&&sugar<=140)
            score+=8;
         else
            score+=3;
      return Math.min(score,100);   
   }
    public static void healthTips(double bmi,int systolic,int diastolic,int sugar,int age,String gender) 
    {
        System.out.println("HEALTH TIPS:");
        if(bmi<18.5)
            System.out.println("Underweight: Increase calorie intake and prioritize proteins and healthy fats");
        else if(bmi>=25&&bmi<30)
            System.out.println("Overweight: Reduce calorie intake and exercise gradually");
        else if(bmi>=30)
            System.out.println("Obese: Consult a healthcare provider for weight management");
        else
            System.out.println("Great!Your BMI is in healthy range.Maintain a healthy diet");
        
        if(systolic<90||diastolic<60)
            System.out.println("LOW BP:Stay hydrated,avoid standing up quickly");
        else if(systolic>=140||diastolic>=90)
            System.out.println("HIGH BP: Reduce salt, manage stress, see a doctor!");
       
        if(sugar<70)
            System.out.println("LOW Blood Sugar:Eat small frequent meals");
        else if(sugar>140)
            System.out.println("HIGH Blood Sugar:Limit sugar intake,consult doctor");
        
        if(age>=50)
            System.out.println("Annual health checkups recommended at your age.");
        
        if(gender.equals("F")&&age>=45)
            System.out.println("Women 45+:Ensure calcium and vitamin D intake."); 
        if(gender.equals("M"))
            System.out.println("Include regular cardio exercises.");
    }
    public static void viewRecords()
    {
        if(healthData.isEmpty()){
            System.out.println("No records found!Please add some first.");
            return;
        }
        System.out.println("<<<ALL HEALTH RECORDS>>>");
        System.out.println("Total Records:"+healthData.size());
        for(int i=0;i<healthData.size();i++)
        {
            String[] arr=healthData.get(i).split(",");
            System.out.println("Record#"+(i+1));
            System.out.println("Name:"+arr[0]);
            System.out.println("Age:"+arr[1]);
            System.out.println("Gender:"+arr[2]);
            System.out.println("Water(glasses):"+arr[3]);
            System.out.println("Sleep(hours):"+arr[4]);
            System.out.println("Exercise(mins):"+arr[5]);
            System.out.println("Height(m):"+arr[6]);
            System.out.println("Weight(kg):"+arr[7]);
            System.out.println("Blood Pressure:"+arr[8]+"/"+arr[9]+"mmHg("+arr[13]+")");
            System.out.println("Blood Sugar:"+arr[10]+"mg/dL("+arr[14]+")");
            System.out.println("BMI:"+arr[11]+" BMI Category:"+arr[12]);
            System.out.println("Health Score:"+arr[15]+"/100");
            System.out.println();
        }    
    }
    public static void filterRecord()
    {
        if(healthData.isEmpty())
        {
            System.out.println("No records to search!");
            return;
        }
        while(true){
        System.out.println("Search Options:");
        System.out.println("1.Search by Name");
        System.out.println("2.Search by BMI Category");
        System.out.println("3.Search by Gender");
        System.out.print("Choose option:");
        int option=0;
        try
        {
            option=input.nextInt();
            input.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Error: Invalid input");
            input.nextLine();
            continue;
        }
        if(option==1){
            searchByName();
            break;
        }
        else if(option==2){
            searchByBMI();
            break;
        }
        else if(option==3){
            searchByGender();
            break;
        }
        else
            System.out.println("Wrong choice!");  
        }
    }
    public static void searchByName()
    {
        System.out.print("Enter name to search:");
        String search=input.nextLine().toLowerCase();
        boolean found=false;
        for(String record:healthData)
        {
            String[] arr=record.split(",");
            if(arr[0].toLowerCase().contains(search))
            {
                displayRecord(arr);
                found=true;
            }     
        }
        if(!found)
            System.out.println("No records found with name "+search); 
     }
    public static void searchByBMI()
    {
        System.out.print("Enter category to search:");
        String category=input.nextLine();
        boolean found=false;
        for(String record:healthData)
        {
            String[] arr=record.split(",");
            if(arr[12].equalsIgnoreCase(category))
            {
                displayRecord(arr);
                found=true;
            }
        }
        if(!found)
            System.out.println("No records found in category "+category); 
    }
    public static void searchByGender()
    {
        System.out.print("Enter gender(M/F):");
        String gen=input.nextLine().toUpperCase();
        boolean found=false;
        for(String record:healthData)
        {
            String[] arr=record.split(",");
            if(arr[2].equals(gen))
            {
                displayRecord(arr);
                found=true;
            }
        }
        if(!found)
            System.out.println("No records found for "+gen);     
    }
    public static void displayRecord(String[] arr)
    {
        try{
        if(arr.length<16)
        {
            System.out.println("ERROR: Corrupted record format!");
            return;
        }
        System.out.println("RECORD FOUND!");
        System.out.println("Name:"+arr[0]);
        System.out.println("Age:"+arr[1]);
        System.out.println("Gender:"+arr[2]);
        System.out.println("Water(glasses):"+arr[3]);
        System.out.println("Sleep(hours):"+arr[4]);
        System.out.println("Exercise(mins):"+arr[5]);
        System.out.println("Height(m):"+arr[6]);
        System.out.println("Weight(kg):"+arr[7]);
        System.out.println("Blood Pressure:"+arr[8]+"/"+arr[9]+"mmHg("+arr[13]+")");
        System.out.println("Blood Sugar:"+arr[10]+"mg/dL("+arr[14]+")");
        System.out.println("BMI:"+arr[11]+" BMI Category:"+arr[12]);
        System.out.println("Health Score:"+arr[15]+"/100");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ERROR: Corrupted record data!");  
        }
    }
    public static void analyzePerformance()
    {
        if(healthData.isEmpty())
        {
            System.out.println("No records to analyze!");
            return;
        }
        int totalScore=0;
        double totalBMI=0;
        int underweight=0,normal=0,overweight=0,obese=0;
        int highest=Integer.MIN_VALUE;
        int lowest=Integer.MAX_VALUE;
        for(String record:healthData)
        {
            String[] arr=record.split(",");
            double scoreDouble=Double.parseDouble(arr[15]);
            int score=(int)scoreDouble;
            double bmi=Double.parseDouble(arr[11]);
            String category=arr[12];
            totalScore+=score;
            totalBMI+=bmi;
            if(score>highest)
                highest=score;
            if(score<lowest)
                lowest=score;
            
            if(category.equals("Underweight"))
                underweight++;
            else if(category.equals("Normal"))
                normal++;
            else if(category.equals("Overweight"))
                overweight++;
            else
                obese++;
        }
            
            int count=healthData.size();
            double avgScore=(double)totalScore/count;
            double avgBMI=totalBMI/count;
            
            System.out.println("\nHEALTH ANALYSIS REPORT");
            System.out.println("Total Records: "+count);
            System.out.printf("Average Health Score:%.2f/100\n",avgScore);
            System.out.println("Highest Score: "+highest);
            System.out.println("Lowest Score: "+lowest);
            System.out.printf("Average BMI: %.2f\n",avgBMI);
            System.out.println("\nBMI Distribution:");
            System.out.println("Underweight: "+underweight);
            System.out.println("Normal: "+normal);
            System.out.println("Overweight: "+overweight);
            System.out.println("Obese: "+obese);
            System.out.println("\nOverall Status");
            if(avgScore>=80)
                System.out.println("EXCELLENT-Keep up the great work!");
            else if(avgScore>=65)
                System.out.println("GOOD-You're on the right track!");
            else if (avgScore>=50)
                System.out.println("FAIR-Room for improvement.");
            else
                System.out.println("NEEDS ATTENTION-Focus on healthier habits!");   
    }
    public static void save()
    {
        FileOutputStream fos=null;
        PrintStream ps=null;
        try
        {
            fos=new FileOutputStream(file);
            ps=new PrintStream(fos);
            for(String record:healthData)
            {
                ps.println(record);
            }
            if(ps.checkError())
            {
                System.out.println("Error occured during saving file!");
            }
            else{
                System.out.println("\nAll Records saved to "+file);
            }
        }
        catch(FileNotFoundException e1)
        {
            System.out.println("ERROR:Cannot create file!");  
        }
        catch(Exception e1)
        {
            System.out.println("ERROR:Failed to save!");
        }
        finally{
            if(ps!=null)
                ps.close();
        }
    }
    public static void loadDataFromFile()
    {
        FileInputStream fis=null;
        Scanner read=null;
        try
        {
            File dataFile=new File(file);
            if(!dataFile.exists())
            {
                System.out.println("No previous record found.Start entering some data first!");
                return;
            }
            fis=new FileInputStream(dataFile);
            read=new Scanner(fis);
            int count=0;
            while(read.hasNextLine())
            {
                String line=read.nextLine();
                if(!line.trim().isEmpty())
                {
                    healthData.add(line);
                    count++;
                }
            }
            System.out.println("Loaded "+count+" previous records!");
        }
        catch(Exception e1)
        {
            System.out.println("ERROR:Failed to load!"+e1.getMessage()); 
        }
        finally
        {
            try
            {
              if(read!=null)  
                  read.close();
              if(fis!=null)
                  fis.close(); 
            }
            catch(Exception e1)
            {
                System.out.println("ERROR:Failed to close file!"); 
            } 
        }
    }
 }//end class