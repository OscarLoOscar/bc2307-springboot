import React from "react";
import{
  Card,
  CardContent,
  CardHeader,
  Divider } from "@mui/material";
import Chart from "react-apexcharts";

const options = {
  xaxis: {
    type: "datatime",
  },
};

const series = [
{
  data: [
  {
    x: new Data(1235465789),
    y: [23456,32546,3243,124],
  }
  ],
},
];

export const CandleStickChart = () => {
  return (
    <>
    <Card>
       <CardContent title="CandleStickChart" />
  <CardHeader />
  <Divider />
    </Card>
    </>
  );
};