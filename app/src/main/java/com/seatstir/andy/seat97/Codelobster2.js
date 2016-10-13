      if($res&&$can_res=="cancel"){

    $resa = $dbh->getdata_table($qr="SELECT *, tr.date as resdate, tr.time as restime FROM tbl_reservations tr
                                LEFT JOIN tbl_performances tp on tr.pid = tp.pid WHERE tr.rid = '$res'");
    //echo $qr;
    $resa = $resa[0];
    $curdatetime = date('Y-m-d H:m:s');

    $cdate = $resa->resdate . ' ' . $resa->restime;
    //echo $cdate;
    $cdate = new DateTime($resa->display_date_end . ' ' . $resa->display_time_end);
    //$cdate = new DateTime($resa->resdate . ' ' . $resa->restime);
    $cdate->sub(new DateInterval('PT6H'));
    $final = $cdate->format('Y-m-d H:i:s');

    if ($final <= $curdatetime && !$meadmin) {
        echo json_encode(array("status"=>"not cancelled", "message"=>"Your reservation cannot be cancelled after the cancellation deadline."));
        exit;
    }
