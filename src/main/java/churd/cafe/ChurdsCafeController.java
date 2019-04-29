package churd.cafe;

import churd.metrics.api.AggregateMetric;
import churd.metrics.api.InMemoryMetricsService;
import churd.metrics.api.WebMetric;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

@Controller
public class ChurdsCafeController {



    // TODO: test the aggregate figures - are they accurate (all 6 values)

    // TODO: test byte size is correct... not adding reseting instead of adding - is that correct????




    @ModelAttribute("metricSearchFormCommand")
    public MetricSearchFormCommand getMetricSearchFormCommand() {
        return new MetricSearchFormCommand();
    }

    @GetMapping("/about")
    public String about(@RequestParam(name="name", required=false, defaultValue="you") String name, Model model) {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        model.addAttribute("name", name);
        return "about";
    }

    @GetMapping("/contact")
    public String contact(@RequestParam(name="name", required=false, defaultValue="you") String name, Model model) {
        model.addAttribute("name", name);
        return "contact";
    }

    @GetMapping("/locations")
    public String locations(@RequestParam(name="name", required=false, defaultValue="you") String name, Model model) {
        model.addAttribute("name", name);
        return "locations";
    }

    @GetMapping("/metrics")
    public String metrics(Model model) {
        AggregateMetric aggregateResponseSizeBytes = InMemoryMetricsService.getInstance().getAggregateResponseSizeBytes();
        model.addAttribute("responseSizeBytesAverage", aggregateResponseSizeBytes.getAverage());
        model.addAttribute("responseSizeBytesMin", aggregateResponseSizeBytes.getMin());
        model.addAttribute("responseSizeBytesMax", aggregateResponseSizeBytes.getMax());

        AggregateMetric aggregateResponseTimeNanos = InMemoryMetricsService.getInstance().getAggregateResponseTimeNanos();
        model.addAttribute("responseTimeMsAverage", _nanoToMs(aggregateResponseTimeNanos.getAverage()));
        model.addAttribute("responseTimeMsMin", _nanoToMs(aggregateResponseTimeNanos.getMin()));
        model.addAttribute("responseTimeMsMax", _nanoToMs(aggregateResponseTimeNanos.getMax()));

        return "metrics";
    }

    @PostMapping("/metricsSubmit")
    public String metricsSubmit(@ModelAttribute("metricSearchFormCommand") MetricSearchFormCommand metricSearchFormCommand, Model model) {
        String metricId = metricSearchFormCommand.getMetricId();
        if (null != metricId && metricId.length() > 0) {
            WebMetric metric = InMemoryMetricsService.getInstance().getWebMetricById(metricId);
            if (null != metric) {
                model.addAttribute("metricIdResult", metric.getId());
                model.addAttribute("requestTimeMs", _nanoToMs(metric.getRequestTimeNanos()));
                model.addAttribute("responseSizeBytes", metric.getResponseByteCount());
            }
            else {
                model.addAttribute("metricNotFound", true);
            }
        }
        return metrics(model);
    }

    private Long _nanoToMs(Long nanos) {
        if (null == nanos) {
            return null;
        }
        return TimeUnit.MILLISECONDS.convert(nanos, TimeUnit.NANOSECONDS);
    }

}

