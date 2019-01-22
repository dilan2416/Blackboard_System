# Blackboard_System

### Description</br>
Functions Introduction</br>
● Roles</br>
  Student can browse Course, signup Course, drop Course, view Course schedule for each Semester, and view the Transcript for    each Semester.</br>
  Student can browse Submission of Assignment, create Submission of Assignment, delete Submission of Assignment, and update Submission of Assignment.</br>
  Teacher can browse Assignment, create Assignment, delete Assignment, and grade Submission from Student.</br>
  Teacher can create Evaluation rule for a Course based on Assignment.</br>
  Course Manager can add Course, delete Course, delete Course, update Course, and browse Course.</br>
  Finance Manager can add Rate for each Course credit, update Rate for each Course credit.</br>
  Finance Manager can add Scholarship, delete Scholarship, update Scholarship, and browse Scholarship.</br>
  Finance Manager can attach Scholarships to Student, delete Scholarships from Students, and browse Scholarship Assignments. 
</br>
● Course</br>
  A Course will have fixed capacity when the signup count of Student reached capacity, student can no longer sign up to that Course.</br>
  A Course can be either online or offline, for offline Course, there must be a Location associated with it, for online Course, there must be a URL associated with it.</br>
● Assignment</br>
  An Assignment will have number of points.</br>
  There are two types of Assignment:</br>
    ○ Essay: which means the Submission must be submitted in the form of a texts.</br>
    ○ Multiple Choice: which means the Submission must be submitted in the form of array of choices among: A, B, C, D. </br>
● Scholarship</br>
  Scholarship will give Student finance benefit for sign up Course. The amount deducted can be either in the form of fixed amount or a rate. For example, $2000 or 10% of overall rate.
  There are two types of Scholarship:</br>
    ○ Status based: The Scholarship can only be applied to Student with certain attribute. For example, from Canada, etc.</br>
    ○ Merit based: The Scholarship can only be applied to Student with certain Grade.</br>
